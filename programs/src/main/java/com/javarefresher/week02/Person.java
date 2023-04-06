package com.javarefresher.week02;

public class Person {
    String name;
    Integer age;

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public Person(String name){
        this(name, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return name.equals(that.name) &&
        age.equals(that.age);
    }
    @Override
    public String toString(){
        return name + " " + age;
    }

    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
}
