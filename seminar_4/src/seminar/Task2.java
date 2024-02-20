/*
В рамках выполнения задачи необходимо:
Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
Получите уникальный список Set на основании List
Определите наименьший элемент (алфавитный порядок)
Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
Удалите все элементы содержащие букву ‘A’
 */


package seminar;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> lst = createList();
        Set<String> setLst = getAsSet(lst);
        listToString(setLst);
        System.out.println(getMinAlphabet(setLst));
        System.out.println(getMaxLengthName(setLst));
        listToString(removeAllWith(setLst, "a"));
    }

    private static Collection<Object> removeAllWith(Set<String> setLst, String a) {
        return setLst.stream().filter(e -> !e.contains(a)).collect(Collectors.toSet());

    }

    private static String getMaxLengthName(Set<String> setLst) {
        return setLst.stream().max((e1, e2) -> Integer.compare(e1.length(), e2.length())).orElse("Empty");
    }

    private static String getMinAlphabet(Set<String> setLst) {
        TreeSet<String> tree = new TreeSet<>(setLst);
//        return tree.getFirst();
        return setLst.stream().min((e1, e2) -> e1.compareTo(e2)).orElse("Empty");
    }

    private static Set<String> getAsSet(List<String> lst) {
        return new HashSet<>(lst);
    }

    static List<String> createList() {
        List<String> lst = new ArrayList<>();
        lst.add("Mary");
        lst.add("Mary");
        lst.add("Mary");
        lst.add("Liza");
        lst.add("Liza");
        lst.add("Izabella");
        lst.add("Margo");
        lst.add("Kate");
        lst.add("Kate");
        lst.add("Yulia");
        lst.add("Sandy");
        lst.add("Red");
        lst.add("John");
        return lst;
    }
    static <T> void listToString(Collection<T> lst) {
        for(T v: lst) {
            System.out.printf(v + " ");
        }
        System.out.println();
    }
}
