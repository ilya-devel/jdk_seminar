package homework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        catalog.add(new Employee(1,333,"Ilya", 10));
        catalog.add(new Employee(1,333,"Ilya", 10));
        catalog.add(new Employee(2,343,"Mary", 3));
        catalog.add(new Employee(3,353,"Liza", 4));
        catalog.add(new Employee(4,363,"Olga", 15));
        catalog.add(new Employee(5,713,"Sam", 1));
        catalog.add(new Employee(6,023,"Jane", 7));
        catalog.add(new Employee(7,333,"Fleur", 16));
        catalog.add(new Employee(8,995,"Freya", 10));

        System.out.println("\n");
        catalog.showListEmployiee();


        System.out.println("\n\nFind by ID");
        System.out.println(catalog.findById(4));
        System.out.println("\nFind by ID with null");
        Employee tmpEmpl = catalog.findById(1000);
        if (tmpEmpl != null) {
            System.out.println(tmpEmpl);
        }
        else {
            System.out.println("Not found");
        }


        System.out.println("\n\nFind by phone number");
        catalog.findByPhoneNumber(333).forEach(System.out::println);
        System.out.println("\nFind by phone number with empty list");
        List<Employee> lst = catalog.findByPhoneNumber(1000);
        if (!lst.isEmpty()) {
            for(Employee empl: lst) {
                System.out.println(empl);
            }
        } else {
            System.out.println("Not found");
        }


        System.out.println("\n\nFind by experience");
        catalog.findByExperience(10).forEach(System.out::println);
        System.out.println("\nFind by experience with empty list");
        List<Employee> lst2 = catalog.findByExperience(1000);
        if (!lst2.isEmpty()) {
            for(Employee empl: lst2) {
                System.out.println(empl);
            }
        } else {
            System.out.println("Not found");
        }
    }
}
