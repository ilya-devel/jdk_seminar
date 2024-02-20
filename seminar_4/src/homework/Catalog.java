package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog implements ICatalog{
    private List<Employee> lstEmployees;

    public Catalog() {
        this.lstEmployees = new ArrayList<>();
    }

    @Override
    public List<Employee> findByExperience(Integer exp) {
//        List<Employee> findLst = lstEmployees.stream().filter(employee -> employee.getExperience() == exp).
//                toList();
//        if (!(findLst.isEmpty())) return findLst;
//        else return null;
        return lstEmployees.stream().filter(employee -> employee.getExperience() == exp).
                collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByPhoneNumber(Integer phoneNum) {
//        List<Employee> findLst = lstEmployees.stream().filter(employee -> employee.getPhoneNumber() == phoneNum).
//                toList();
//        if (!(findLst.isEmpty())) return findLst;
//        else return null;
        return lstEmployees.stream().filter(employee -> employee.getPhoneNumber() == phoneNum).
                collect(Collectors.toList());
    }

    @Override
    public Employee findById(Integer idNum) {
        return lstEmployees.stream().
                filter(employee -> employee.getIdNum() == idNum).
                findFirst().orElse(null);
    }

    @Override
    public void add(Employee newEmployee) {
        Employee empl = findById(newEmployee.getIdNum());
        if (!(empl==null)) {
            System.out.println("An employee with the same id already exists");
            return;
        }
        this.lstEmployees.add(newEmployee);
        System.out.println("Add new employee: " + newEmployee);
    }

    public void showListEmployiee () {
        System.out.println("List employees:");
        for (Employee empl: this.lstEmployees) {
            System.out.println("\t" + empl);
        }
    }
}
