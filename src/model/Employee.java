package model;

public class Employee {
    Integer id;
    String name;
    String city;
    Double salary;

    public Employee(Integer id, String name, String city, Double salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.salary = salary;
    }
    public Employee(String name, String city, Double salary) {
        this.name = name;
        this.city = city;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public Double getSalary() {
        return salary;
    }
}
