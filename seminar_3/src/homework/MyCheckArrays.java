package homework;

public class MyCheckArrays {
    public static <T> boolean compareArrays(T[] arrayOne, T[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) return false;
        for (int i = 0; i < arrayOne.length; i++) {
            if (!arrayOne[i].getClass().getSimpleName().equals(arrayTwo[i].getClass().getSimpleName())) return false;
        }
        return true;
    }
}
