package com.javarefresher.week01;
class Shape {
    public void display() {
       System.out.println("Inside display");
    }
 }
 class Line extends Shape{
    public void length(){
        System.out.println("Inside length");
    }
 }
 class Rectangle extends Line {
    public void area() {
       System.out.println("Inside area");
    }
 }

 class Cube extends Rectangle {
    public void volume() {
       System.out.println("Inside volume");
    }
 }
 public class MultiLevelInheritance {
    public static void main(String[] arguments) {
       Cube cube = new Cube();
       Rectangle cb =  new Cube();
       cb.display();
       cb.length();
       cb.area();
       //cb.volume();//Error
       cube.display();
       cube.length();
       cube.area();
       cube.volume();
    }
 }