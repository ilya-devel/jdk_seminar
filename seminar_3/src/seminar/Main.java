package seminar;

import java.io.DataInputStream;

public class Main {
    public static void main(String[] args) {
        SomeClass<String, DataInputStream, Integer> someClass = new SomeClass<>("Some text", new DataInputStream((System.in)), 11);
        someClass.getClasses();

        MyCollection<Integer> tmp = new MyCollection<>();
        tmp.add(10);
        tmp.add(3);
        tmp.add(10);
        tmp.add(10);
        System.out.println(tmp.toString());
        tmp.remove(1);
        System.out.println(tmp.toString());
        for (Object n: tmp) {
            System.out.println(n);
        }
    }
}
