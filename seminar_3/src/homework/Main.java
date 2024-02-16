package homework;

import homework.test_classes.Apple;
import homework.test_classes.Fruit;
import homework.test_classes.Orange;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1:\n");
        int a = 3;
        float b = 3.3f;
        BigDecimal result = BigDecimal.valueOf((Double) Calculator.<Number>sum(a, b));
        System.out.println(result.setScale(3, RoundingMode.HALF_UP));
        result = BigDecimal.valueOf((Double) Calculator.<Number>subtract(a, b));
        System.out.println(result.setScale(3, RoundingMode.HALF_UP));
        result = BigDecimal.valueOf((Double) Calculator.<Number>multiply(a, b));
        System.out.println(result.setScale(3, RoundingMode.HALF_UP));
        result = BigDecimal.valueOf((Double) Calculator.<Number>divide(a, b));
        System.out.println(result.setScale(3, RoundingMode.HALF_UP));

        System.out.println("\nTask 2:\n");
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {1, 2, 3, 4, 5, 6};
        Float[] arr3 = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        Character[] arr4 = {'a', 'b', 'c', 'd', 'e'};
        Fruit[] arr5 = {new Orange(), new Orange(), new Orange()};
        Orange[] arr6 = {new Orange(), new Orange(), new Orange()};
        Apple[] arr7 = {new Apple(), new Apple(), new Apple()};
        System.out.println(MyCheckArrays.compareArrays(arr1, arr1));
        System.out.println(MyCheckArrays.compareArrays(arr1, arr2));
        System.out.println(MyCheckArrays.compareArrays(arr1, arr3));
        System.out.println(MyCheckArrays.compareArrays(arr1, arr4));
        System.out.println(MyCheckArrays.compareArrays(arr5, arr5));
        System.out.println(MyCheckArrays.compareArrays(arr5, arr6));
        System.out.println(MyCheckArrays.compareArrays(arr5, arr7));

        System.out.println("\nTask 3:\n");

        Pair<Integer, Float> tmp1 = new Pair<>(11, 1.3f);
        System.out.println(tmp1);
        Pair<Orange, Apple> tmp2 = new Pair<>(new Orange(), new Apple());
        System.out.println(tmp2);

    }
}
