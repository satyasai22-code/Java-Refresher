package com.javarefresher.week04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question0304 {
    public static void main(String[] args) {
        
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Satya", 300),
                new Employee(2, "Sai" , 1000),
                new Employee(3, "Hari" , 400),
                new Employee(4, "Rama", 710),
                new Employee(5, "Krishna", 700),
                new Employee(6, "Aditya" , 950),
                new Employee(7, "Arjun" , 950),
                new Employee(8, "Aryan" , 950)
        );

        // Question - 03
        // Sort Based on Salary

        Comparator<Employee> compareBasedOnSalary = (i1, i2) -> i1.getSalary().compareTo(i2.getSalary());
        employees.sort(compareBasedOnSalary);
        System.out.println(employees);
        

        // Question - 04
        // Group Employees Based on Salary

        Map<Integer,List<Employee>> employeeMap
        = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println("Employees grouped by Salary");
        employeeMap.forEach((Integer key, List<Employee> empList) -> System.out.println(key +" -> "+empList));
    }
}
