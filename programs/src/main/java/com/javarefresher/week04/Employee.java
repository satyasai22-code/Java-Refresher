package com.javarefresher.week04;

public class Employee {
    private int id;
    private String name;
    private Integer salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public Integer getSalary() {
        return salary;
    }
    @Override
    public String toString(){
        return "[" + " id: " + id + " name: "+ name + " salary: " + salary + " ]";
    }
}
