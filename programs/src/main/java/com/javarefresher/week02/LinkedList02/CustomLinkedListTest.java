package com.javarefresher.week02.LinkedList02;

import com.javarefresher.week02.Person;

public class CustomLinkedListTest {
    public static void main(String[] args) {
        CustomLinkedList<Person> linkedList = new CustomLinkedList<Person>();
        linkedList.add(new Person("Satya", 20));
        linkedList.add(new Person("Sai", 21));
        linkedList.add(new Person("Neelapala", 22));
        linkedList.add(new Person("Jai", 23));
        linkedList.add(new Person("Jay", 24));
        linkedList.printAll();
        linkedList.delete(new Person("Satya", 20));
        linkedList.printAll();
        linkedList.delete(new Person("Jay", 24));
        linkedList.printAll();
        linkedList.delete(new Person("Neelapala", 22));
        linkedList.printAll();
        linkedList.delete(new Person("Sai", 21));
        linkedList.printAll();
    }
}
