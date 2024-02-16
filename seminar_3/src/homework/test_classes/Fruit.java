package homework.test_classes;

abstract public class Fruit {
    private static float weight;

    public static float getWeight() {
        return weight;
    }

    public static void setWeight(float weight) {
        Fruit.weight = weight;
    }
}
