package seminar;

import static java.lang.Thread.*;

public class Task2 {
    volatile private static Boolean switcher;
    private static Boolean work = true;
    private static int counter;

    public static void main(String[] args) {
        switcher = true;
        counter = 100;


        Thread threadA = new Thread(() -> {
            System.out.println("Start threadA");
            while (work) {
                switcher = !switcher;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(switcher);
            }

        });

        Thread threadB = new Thread(() -> {
            System.out.println("Start threadB");
            while (counter > 0) {
                if (!switcher) {
                    System.out.println(counter);
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    counter--;
                }
            }
            work = false;
        });

        threadA.start();
        threadB.start();
    }
}
