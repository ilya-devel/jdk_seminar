package homework;

import java.io.Serial;

public class Employee {
    private int idNum;
    private int phoneNumber;
    private String name;
    private int experience;

    public Employee(int idNum, int phoneNumber, String name, int experience) {
        this.idNum = idNum;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getIdNum() {
        return idNum;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }


    public String getName() {
        return name;
    }


    public int getExperience() {
        return experience;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "idNum=" + idNum +
                ", phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
