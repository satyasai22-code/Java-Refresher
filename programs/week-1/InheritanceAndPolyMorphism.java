class Quadrilateral {
    public void area(){
        System.out.println("Area of Quadrilateral is area enclosed by four sides");
    }
 }
 class Rectangle extends Quadrilateral {
    @Override
    public void area() {
       System.out.println("Area of Rectangle is length * breadth");
    }
 }

 class Square extends Quadrilateral {
    @Override
    public void area() {
        System.out.println("Area of Square is side * side");
    }
 }
 public class InheritanceAndPolyMorphism {
    public static void main(String[] arguments) {
        Quadrilateral rectangle = new Rectangle();
        Quadrilateral square = new Square();
        rectangle.area();
        square.area();
     }
}
