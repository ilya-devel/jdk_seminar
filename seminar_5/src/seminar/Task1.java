package seminar;

public class Task1 {
    static class SomeObj {
        private int someData;

        SomeObj() {
            this.someData = 0;
        }

        public void setSomeData(int someData) {
            this.someData = someData;
        }
    }

    public static void main(String[] args) {
        SomeObj objA = new SomeObj();
        SomeObj objB = new SomeObj();

        Thread task1 = new Thread(() -> {
            synchronized (objA) {
                System.out.println("Block object A, waiting object B");
                synchronized (objB) {
                    System.out.println("Block object B, waiting object A");
                }
            }
        });

        Thread task2 = new Thread(() -> {
            synchronized (objB) {
                System.out.println("Block object B, waiting object A");
                synchronized (objA) {
                    System.out.println("Block object A, waiting object B");
                }
            }
        });

        task1.start();
        task2.start();
    }
}
