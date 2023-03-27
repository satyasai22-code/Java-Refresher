package com.javarefresher.week01;

public class StringClass {
    public static void main(String[] args) {
        String s1 = new String("HEllo");//2 objects will be created.1 in heap and 1 in SP
        s1.concat("Satya");//1 object will be created in SP as "Satya" is new literal and s1 will be "Hello" as strings are immutable
        System.out.println(s1);
        s1 = s1.concat("Satya");//Only 1 Object will be created in Heap as "Satya" is present in SP and s1 will be "HelloSatya"
        System.out.println(s1);

        //String Methods
        System.out.println("Char at first index: " + s1.charAt(1));
        System.out.println("is s1 empty: " + s1.isEmpty());

        String s2 = new String("lowercase");
        System.out.println("s1 == s1.toLowerCase(): " +( s1 == s1.toLowerCase())); //If there is a change required upon method calling, then new object is created
        System.out.println("s2 == s2.toLowerCase(): " +(s2 == s2.toLowerCase()));// If there is no change required upon method calling, then no new object will be created

        String s3 = "HEllo";//1 object is created in SP only
        String s4 = new String("HEllo");
        System.out.println("s3 == s4: " + (s3 == s4)); // false as s4 is in heap and s3 is in SP

        String s5 = "HEllo";
        String s6 = new String("HEllo");
        System.out.println("s3 == s5: " + (s3 == s5)); // true only one object gets created for one literal in SP but can have multiple references
        System.out.println("s4 == s6: " + (s4 == s6)); // false as new objects gets created every time in heap with new object 

    }
    
}
