package com.javarefresher.week05.designpatterns.structuraldesignpatterns.decoratorpattern;

// Decorator design pattern allows us to dynamically add functionality and behavior to an object
// without affecting the behavior of other existing objects within the same class.


interface Shape{
    abstract void draw();
} 

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle is Drawn");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle is Drawn");
    }
}

abstract class ShapeDecorator implements Shape{
    protected Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }
    public void draw() {
        decoratedShape.draw(); 
    }
}

class RedShapeDecorator implements Shape{
    protected Shape decoratedShape;
    public RedShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }
    public void draw() {
        decoratedShape.draw(); 
        setRedBorder();
    }
    private void setRedBorder(){
        System.out.println("Border Color is Red");
    }
}

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
 
        System.out.println("Circle with normal border");
        circle.draw();
        System.out.println("\nCircle of red border");
        redCircle.draw();
        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
