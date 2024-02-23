package seminar;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Task3 {

    static class Runner extends Thread implements Runnable {
        private String name;
        private CountDownLatch latch;

        public Runner(String name, CountDownLatch latch) {
            this.name = name;
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                goToStart();
                latch.await();
//                latch.countDown();
                running();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private void goToStart() {
            System.out.println(name + " go to start line");
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " on start line");
            latch.countDown();
        }

        private void running() {
            System.out.println(name + " is started");
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " is finished");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);

        Thread runnerA = new Runner("runnerA", latch);
        Thread runnerB = new Runner("runnerB", latch);
        Thread runnerC = new Runner("runnerC", latch);

        runnerA.start();
        runnerB.start();
        runnerC.start();



        while (latch.getCount() != 1) {
            Thread.sleep(100);
        }
        System.out.println("Start");
        Thread.sleep(500);
        System.out.println("Warning");
        Thread.sleep(500);
        System.out.println("GO!");
        Thread.sleep(500);

        latch.countDown();
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
