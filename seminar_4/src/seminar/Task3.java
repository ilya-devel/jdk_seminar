/*
В рамках выполнения задачи необходимо:
    1. Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
    2. Найдите человека с самым маленьким номером телефона
    3. Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */
package seminar;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        Map<String, String> phoneBook = getPhoneBook();
        System.out.println(getMinPhoneNumber(phoneBook));
        System.out.println(getMaxAlphabetName(phoneBook));
    }

    private static String getMaxAlphabetName(Map<String, String> phoneBook) {
        return phoneBook.values().stream().max((e1, e2) -> e1.compareTo(e2)).get();
    }

    private static String getMinPhoneNumber(Map<String, String> phoneBook) {
        return phoneBook.get(phoneBook.keySet().stream().min((e1, e2) -> e1.compareTo(e2)).get());
//        return phoneBook.get(phoneBook.keySet().stream().
//                min().
//                get());
    }

    static Map<String, String> getPhoneBook() {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("1112223334", "Mary");
        phoneBook.put("2223334445", "Liza");
        phoneBook.put("3334445556", "Kate");
        phoneBook.put("4445556667", "Olga");
        phoneBook.put("5556667778", "Margo");
        phoneBook.put("6667778889", "Jane");
        return phoneBook;
    }
}
