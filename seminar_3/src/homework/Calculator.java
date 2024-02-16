package homework;

public class Calculator {
    public static <T extends Number> Number sum(T numA, T numB) {
        return numA.doubleValue() + numB.doubleValue();
    }

    public static <T extends Number> Number subtract(T numA, T numB) {
        return numA.doubleValue() - numB.doubleValue();
    }

    public static <T extends Number> Number multiply(T numA, T numB) {
        return numA.doubleValue() * numB.doubleValue();
    }

    public static <T extends Number> Number divide(T numA, T numB) {
        return numA.doubleValue() / numB.doubleValue();
    }

}
