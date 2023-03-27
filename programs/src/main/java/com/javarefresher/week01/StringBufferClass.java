package com.javarefresher.week01;

public class StringBufferClass {
    public static void main(String[] args) {

        System.out.println(new StringBuffer().capacity());// default capacity is 16

        StringBuffer s1 = new StringBuffer("Hello ");//intial capacity = defailt capacity + length of the literal
        System.out.println("Initial Capacity: " + s1.capacity());    
        s1.append("Satya Sai! Welcome ");// If new str length is greateer than capacity, then new_capacity = (old_capacity + 1) * 2;        
        System.out.println(s1.capacity());     

        System.out.println(s1.append("!!!"));

        System.out.println(s1.insert(6,"Java "));

        System.out.println(s1.replace(6, 11, "Python "));

        System.out.println(s1.delete(6, 13));
        s1.reverse();
        System.out.println(s1);
        System.out.println(s1.capacity());
        s1.setLength(4);//only first 4chars will be considered
        System.out.println(s1);

        s1.ensureCapacity(10);//minimum capacity
        System.out.println(s1);
        System.out.println("s1 capacity before trim to size: " + s1.capacity());

        s1.trimToSize();//Extra memory will be deallocated
        System.out.println("s1 capacity after trim to size: " + s1.capacity());
        StringBuffer s2 = new  StringBuffer("Hello");
        StringBuffer s3 = new StringBuffer("Hello");

        System.out.println("s2 == s3: " +(s2 == s3));//Checks checks for reference
        System.out.println("s2 == s3:" + s2.equals(s3));//Checks for reference as .equals method is not overriden from Object class

    }
}
