package com.javarefresher.week01;
class A{
}
class B extends A{
}
class Parent {
    A myFunction1(){
        System.out.println("Parent A");
        return new A();
    }
    B myFunction2(){
        System.out.println("Parent B");
        return new B();
    }
}
class Child extends Parent{
    B myFunction1(){
        System.out.println("Child B");
        return new B();
    }
//Error as A is not covariant of B
    // A myFunction2(){
    //     System.out.println("Child A");
    //     return new A();
    // }
}
public class Covariants {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.myFunction1();
        Child child = new Child();
        child.myFunction1();
    }
}
