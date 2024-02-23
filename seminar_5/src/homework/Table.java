package homework;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Table {

    public void startProcess() {
        int MAX_COUNT = 5;
        CountDownLatch latch = new CountDownLatch(MAX_COUNT + 1);

        Fork[] forks = new Fork[MAX_COUNT];
        for (int i = 0; i < MAX_COUNT; i++) {
            forks[i] = new Fork("Вилка" + i);
        }

        Philosophy[] philosophies = new Philosophy[MAX_COUNT];
        for (int i = 0; i < MAX_COUNT; i++) {
            philosophies[i] = new Philosophy("Макаронный философ " + i, forks[i], forks[i < MAX_COUNT - 1 ? i + 1 : 0], latch);
        }

        Arrays.stream(philosophies).forEach((Thread::start));

        System.out.println("Начинаем процесс принятия пищи и раздумий:");
        latch.countDown();
    }
}
