package homework;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosophy extends Thread {
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private int countEating = 3;
    private boolean isHungry = true;
    private final CountDownLatch latch;

    Philosophy (String name, Fork leftFork, Fork rightFork, CountDownLatch latch) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.latch = latch;
        latch.countDown();
    }

    @Override
    public void run() {
        try {
            latch.await();
            while (isHungry) {
                if (leftFork.isUsing() && rightFork.isUsing()) eatingProcess();
                System.out.println(this.name + " размышляет");
                Thread.sleep(1000L * new Random().nextInt(1, 10));
            }
            System.out.println(name + " наелся");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void eatingProcess() {
        leftFork.setUsing(true);
        rightFork.setUsing(true);
        System.out.println(name + " кушает используя " + leftFork.getName() + " и " + rightFork.getName());
        try {
            Thread.sleep(1000L * new Random().nextInt(1, 10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        countEating--;
        leftFork.setUsing(false);
        rightFork.setUsing(false);
        if (countEating <= 0) {
            isHungry = false;
        }
    }

    @Override
    public String toString() {
        return "Philosophy{" +
                "name='" + name + '\'' +
                "with forks: " + leftFork + ", " + rightFork+ '}';
    }
}
