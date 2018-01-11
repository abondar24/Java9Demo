package org.abondar.experimental.streamdemo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class CollectorsDemo {

    public static void main(String[] args) {
        System.out.println("filtering() demo");
        filteringDemo();

        System.out.println("flatMapping() demo");
        flatMappingDemo();
    }

    private static void filteringDemo() {
        Map<String,List<Employee>> empByDeptWith2Lang = Employee.employees()
                .stream()
                .collect(groupingBy(Employee::getDepartment,
                        filtering(e->e.getLanguages().size()>=2 &&
                                e.getLanguages().contains("English"),toList()))) ;
        System.out.println("Employees grouped by department with two" +
                " languages who speak English:");
        System.out.println(empByDeptWith2Lang);
    }

    private static void flatMappingDemo() {
        Map<String,Set<String>> langsByDept = Employee.employees()
                .stream()
                .collect(groupingBy(Employee::getDepartment,flatMapping(e->e.getLanguages().stream(),toSet())));
        System.out.println("Languages spoken by department:");
        System.out.println(langsByDept);
    }

}
