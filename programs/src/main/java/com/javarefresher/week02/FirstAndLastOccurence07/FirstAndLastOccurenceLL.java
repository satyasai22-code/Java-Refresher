package com.javarefresher.week02.FirstAndLastOccurence07;

import java.util.Iterator;
import java.util.LinkedList;

import com.javarefresher.week02.Person;

public class FirstAndLastOccurenceLL {
    public static void firstAndLastOccurence(LinkedList<Person> linkedList, Person person){
        Iterator<Person> iterator = linkedList.iterator();
        int lastOccurence = -1, firstOccurence = -1, iterationCount = 0;
        while (iterator.hasNext()) 
        {
            iterationCount++;
            if(iterator.next().equals(person)) {
                if(firstOccurence == -1){
                    firstOccurence = iterationCount;
                }else {
                    lastOccurence = iterationCount;
                }
            }
        }
        if(firstOccurence != -1) {
            System.out.println("First occurence of " + person + " is at : " + firstOccurence + " position");
        }
        else {System.out.println("Given element not found"); return;
    }

        if(lastOccurence != -1) {
            System.out.println("Last occurence of " + person + " is at : " + lastOccurence + " position");
         }
         else{
            System.out.println("Last occurence of " + person + " is also at : " + firstOccurence + " position");
        }
    }
    public static void main(String[] args) {
        LinkedList<Person> linkedList = new LinkedList<>();
        linkedList.add(new Person("Satya", 20));
        linkedList.add(new Person("Sai", 21));
        linkedList.add(new Person("Neelapala", 22));
        linkedList.add(new Person("Jai", 23));
        linkedList.add(new Person("Jay", 24));
        linkedList.add(new Person("Satya", 20));

        final Person person1 = new Person("Satya", 20);
        final Person person2 = new Person("Sai", 21);
        final Person person3 = new Person("Satya", 22);
        final Person person4 = new Person("New", 0);

        firstAndLastOccurence(linkedList, person4);
        firstAndLastOccurence(linkedList, person3);
        firstAndLastOccurence(linkedList, person2);
        firstAndLastOccurence(linkedList, person1);
    }
}
