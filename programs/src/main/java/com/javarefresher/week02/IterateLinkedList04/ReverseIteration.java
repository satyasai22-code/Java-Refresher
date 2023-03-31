package com.javarefresher.week02.IterateLinkedList04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ReverseIteration {
 public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(2);
    linkedList.add(2023);

    ListIterator<Integer> listIterator = linkedList.listIterator(linkedList.size());

    while (listIterator.hasPrevious())
    {
        System.out.println(listIterator.previous());
    }
    
    Iterator<Integer> iterator = linkedList.descendingIterator();
  
    while (iterator.hasNext()) 
    {
        System.out.println(iterator.next());
    }
 }
}
