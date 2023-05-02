package com.javarefresher.week05.designpatterns.creationaldesignpatterns.prototypepattern;


// 1. Use the Prototype pattern 
// when your code shouldn’t depend on the concrete classes of objects that you need to copy.

// 2. Use the pattern when 
// you want to reduce the number of subclasses that only differ in the way 
// they initialize their respective objects.

abstract class Shape{
    public int x;
    public int y;
    public String color;

    public Shape(){
    }

    //Must have copy constructor with all fields intialized
    public Shape(Shape shape){
        if(shape != null){
            this.x = shape.x;
            this.y = shape.y;
            this.color = shape.color;
        }
    }
    public abstract Shape clone();
}

class Circle extends Shape{
    private int radius;

    public Circle(){
    }

    public Circle(int radius){
        this.radius = radius;
    }
    public Circle(Circle circle) {
        super(circle); 
        if(circle != null){
            this.radius = circle.radius
;        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public String toString(){
        return "[ Circle radius: " + radius+ "]";
    }
}

class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle(){
    }
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    public Rectangle(Rectangle rectangle){
        super(rectangle);
        if(rectangle != null){
            this.width = rectangle.width;
            this.height = rectangle.height;
        }
    }
    @Override
    public Shape clone(){
        return new Rectangle(this);
    }

    @Override
    public String toString(){
        return "[ Rectanlge's width height: " + width + " " + height + " " + "]";
    }
}


public class PrototypePatternTest {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Rectangle rectangle = new Rectangle(20, 30);
        System.out.println("Before cloning");
        System.out.println(circle);
        System.out.println(rectangle);

        Circle circleClone = (Circle) circle.clone(); 
        Rectangle rectangleClone = (Rectangle) rectangle.clone();
        System.out.println("After cloning");
        System.out.println(circleClone);
        System.out.println(rectangleClone);

    }
}
