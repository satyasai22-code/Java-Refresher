package com.javarefresher.week02.LinkedList;

public class CustomLinkedListTest {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.printAll();
        linkedList.delete(1);
        linkedList.printAll();
        linkedList.delete(5);
        linkedList.printAll();
        linkedList.delete(3);
        linkedList.printAll();
        linkedList.delete(2);
        linkedList.printAll();
    }
}
