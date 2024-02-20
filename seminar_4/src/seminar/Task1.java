package seminar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> lst = createList();
        listToString(sortByAlphabet(lst));
        listToString(sortByLength(lst));
        listToString(reverse(lst));
    }

    private static List<String> sortByLength(List<String> lst) {
//        lst.stream().sorted((e1, e2) -> e1.length() - e2.length());
        return lst.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    private static List<String> sortByAlphabet(List<String> lst) {
//        lst.sort(null);
//        lst.sort((e1, e2) -> e1.compareTo(e2));
        lst.sort(String::compareTo);
        return lst;
    }

    static List<String> reverse(List<String> lst) {
        return lst.stream().sorted(Comparator.reverseOrder()).toList();
    }

    static List<String> createList() {
        List<String> lst = new ArrayList<>();
        lst.add("Mary");
        lst.add("Liza");
        lst.add("Izabella");
        lst.add("Margo");
        lst.add("Kate");
        lst.add("Yulia");
        lst.add("Sandy");
        return lst;
    }

    static <T> void listToString(List<T> lst) {
        for(T v: lst) {
            System.out.printf(v + " ");
        }
        System.out.println();
    }
}
