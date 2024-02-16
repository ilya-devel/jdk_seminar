package lesson;

import java.util.LinkedList;

public class Box <T extends Fruit> {
    private LinkedList<T> lstFruits = new LinkedList<>();

    public float getWeight() {
        if (!lstFruits.isEmpty()) {
            float summary = 0;
            for (T fruit: lstFruits) {
                summary += fruit.getWeight();
            }
            return summary;
        }
        return 0;
    }

    public void add(T fruit) {
        lstFruits.add(fruit);
    }
    public boolean compareWeight(Box box) {
        return this.getWeight() == box.getWeight();
    }
}
