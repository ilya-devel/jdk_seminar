package homework;

import java.util.List;

public interface ICatalog {
    List<Employee> findByExperience(Integer exp);
    List<Employee> findByPhoneNumber(Integer phoneNum);
    Employee findById(Integer id);
    void add(Employee newEmployee);
}
