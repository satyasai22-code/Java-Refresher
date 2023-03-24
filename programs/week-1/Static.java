class Parent{
    //static variable
    static int count;
    //static block for intialization of static variables
    static{
        count = 1;
    }
    //static method to access without object creation
    static int add(int a, int b){
        return a + b;
    }
}

class Child extends Parent{
    //variable hiding
    static int count;
    static{
        count = 2;
    }
    //method hiding
    static int add(int a, int b){
        return a + b + 1;
    }
}
public class Static {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();
        Parent pc = new Child();
        System.out.println("Parent Count: " + Parent.count);
        System.out.println("Child Count: " + Child.count);
        System.out.println("Parent as reference Count: " + pc.count);

        Parent.count++;
        System.out.println("Parent Count: " + Parent.count);
        System.out.println("Child Count: " + Child.count);
        System.out.println("Parent as reference Count: " + pc.count);

        Child.count++;
        System.out.println("Parent Count: " + Parent.count);
        System.out.println("Child Count: " + Child.count);
        System.out.println("Parent as reference Count: " + pc.count);

        System.out.println("Parent add: " + Parent.add(1, 2));
        System.out.println("Child add: " + Child.add(1, 2));
        System.out.println("Parent as reference and Object add: " + p.add(1, 2));
        System.out.println("Child as reference and Object add: " + c.add(1, 2));
        System.out.println("Parent as reference and child as Object add: " + Parent.add(1, 2));
    }
}
