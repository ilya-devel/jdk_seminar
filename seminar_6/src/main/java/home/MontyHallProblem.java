package home;

import lombok.*;

import java.util.LinkedList;
import java.util.Random;

@NoArgsConstructor
public class MontyHallProblem implements Runnable {
    private enum Prizes {CAR, GOAT}

    Prizes[] doors = new Prizes[3];
    Random rnd = new Random();
    LinkedList<Boolean> resultsIfNotChange = new LinkedList<>();
    LinkedList<Boolean> resultsIfChange = new LinkedList<>();


    private void putRandomPrize() {
        doors = new Prizes[]{Prizes.GOAT, Prizes.GOAT, Prizes.GOAT};
        int carIndex = rnd.nextInt(doors.length);
        doors[carIndex] = Prizes.CAR;
    }

    private Boolean startGame(boolean change) {
        putRandomPrize();
        int choice = rnd.nextInt(doors.length);
        if (!change) return doors[choice] == Prizes.CAR;
        Integer monty = getGoatDoor(choice);
        if (monty == null) {
            throw new RuntimeException("Внутренний сбой: при открытии двери ведущим, дверь с козлом не обнаружена");
        }
        for (int i = 0; i < doors.length; i++) {
            if (i != monty && i != choice) return doors[i] == Prizes.CAR;
        }
        return null;
    }

    @Override
    public void run() {
        while (resultsIfNotChange.size() < 1000 &&
                resultsIfChange.size() < 1000) {
            resultsIfChange.add(startGame(true));
            resultsIfNotChange.add(startGame(false));
        }
        showResultAnalysis();
    }

    private Integer getGoatDoor(int choice) {
        for (int i = 0; i < doors.length; i++) {
            if (i != choice && doors[i] == Prizes.GOAT) return i;
        }
        return null;
    }

    private void showResultAnalysis(){
        System.out.println(resultsIfChange.get(999));
        int winsIfChange = resultsIfChange.stream().filter((e) -> e).toList().size();
        int winsIfNotChange = resultsIfNotChange.stream().filter((e) -> e).toList().size();
        System.out.println("В результате проверки парадокса Монти Холла, полученны следующие результаты.");
        System.out.println("При запуске игры 1000 для обоих случаев (когда идёт смена выбора и когда нет:)");
        System.out.println("Без смены выбора, количество побед: " + winsIfNotChange + " или " + ((double)winsIfNotChange/10) + "%");
        System.out.println("Если поменять выбор, количество побед: " + winsIfChange + " или " + ((double)winsIfChange/10) + "%");
    }
}
