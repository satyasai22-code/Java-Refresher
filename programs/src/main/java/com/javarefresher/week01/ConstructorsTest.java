package com.javarefresher.week01;

class Constructor{
    private int count;
    private String name;

    //no args constuctor
    public Constructor() {
        this.count = 0;
        this.name = "default";
    }
    //parameterized constuctor
    public Constructor(int count, String name){
        this.count = count;
        this.name = name;
    }

    //copy Constructor
    public Constructor(Constructor constructor){
        this(constructor.getCount(), constructor.getName());
    }
        public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
public class ConstructorsTest {
    public static void main(String[] args) {
        Constructor c1 = new Constructor();
        System.out.println(c1.getName() + " " + c1.getCount());
        Constructor c2 = new Constructor(1, "Paramaterized");
        System.out.println(c2.getName() + " " + c2.getCount());
        Constructor c3 = new Constructor(c2);
        System.out.println(c3.getName() + " " + c3.getCount());    }
}
