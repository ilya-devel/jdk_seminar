package seminar;

import java.io.DataInput;
import java.io.InputStream;

public class SomeClass <T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private T someType;
    private V someValue;
    private K someKey;

    public SomeClass(T someType, V someValue, K someKey) {
        this.someType = someType;
        this.someValue = someValue;
        this.someKey = someKey;
    }

    public T getSomeType() {
        return someType;
    }

    public V getSomeValue() {
        return someValue;
    }

    public K getSomeKey() {
        return someKey;
    }

    public void getClasses() {
        System.out.println("someType: " + someType.getClass().getSimpleName() +
                "\nsomeValue: " + someValue.getClass().getSimpleName() +
                "\nsomeKey: " + someKey.getClass().getSimpleName());
    }
}
