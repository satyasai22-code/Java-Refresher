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
    public int area(int l, int b){
        return l*b;
    }
 }

 class Square extends Quadrilateral {
    @Override
    public void area() {
        System.out.println("Area of Square is side * side");
    }
    public int area(int l){
        return l*l;
    }
 }
 public class InheritanceAndPolyMorphism {
    public static void main(String[] arguments) {
        Rectangle rectangle = new Rectangle();
        Square square = new Square();
        rectangle.area();
        System.out.println(rectangle.area(2, 4));
        square.area();
        System.out.println(square.area(2));
     }
}
