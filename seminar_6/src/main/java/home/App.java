package home;

public class App {
    public static void main(String[] args) {
        MontyHallProblem mhp = new MontyHallProblem();
        try {
            mhp.run();
        } catch (RuntimeException exception) {
            System.out.println(exception);
        }
    }
}