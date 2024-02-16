package lesson;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 10; i++) {
            appleBox.add(new Apple());
        }
        System.out.println(appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 10; i++) {
            orangeBox.add(new Orange());
        }
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compareWeight(orangeBox));
    }
}
