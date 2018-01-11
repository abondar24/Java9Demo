package org.abondar.experimental.streamdemo;


import java.util.List;

public class Employee {

    private String name;
    private  String department;
    private double salary;
    private List<String> languages;

    public Employee(String name, String department, double salary, List<String> languages) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", languages=" + languages +
                '}';
    }

    public static List<Employee> employees() {
        return List.of(
                new Employee("John", "Sales", 1000.89, List.of("English", "French")),
                new Employee("Wally", "Sales", 900.89, List.of("Spanish", "Wu")),
                new Employee("Ken", "Sales", 1900.00, List.of("English", "French")),
                new Employee("Li", "HR", 1950.89, List.of("Wu", "Lao")),
                new Employee("Manuel", "IT", 2001.99, List.of("English", "German")),
                new Employee("Tony", "IT", 1700.89, List.of("English"))
        );
    }
}
