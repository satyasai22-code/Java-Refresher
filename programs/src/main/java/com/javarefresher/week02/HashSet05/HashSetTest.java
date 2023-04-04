package com.javarefresher.week02.HashSet05;

import java.util.Arrays;
import java.util.HashSet;

import com.javarefresher.week02.Person;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Person> set1 = new HashSet<Person>(
            Arrays.asList(
                 new Person("Satya", 20),
                 new Person("Sai", 21),
                 new Person("Neelapala", 22),
                 new Person("Jai", 23),
                 new Person("Jay", 24)
                 )
            );

            HashSet<Person> set2 = new HashSet<Person>(
                Arrays.asList(
                     new Person("Satya", 20),
                     new Person("Sai", 21),
                     new Person("Neelapala", 22),
                     new Person("Jai", 23),
                     new Person("Jay", 24),
                     new Person("Satya", 20)
                     )
                );

                System.out.println(set1);
                System.out.println(set2);

        System.out.println(set1.equals(set2));
        System.out.println(set1 == set2);
        set1.add(new Person("Jaya", 24));
        set2.add(new Person("Jaya", 24));

        System.out.println(set1.equals(set2));

        set1.remove(new Person("Satya", 20));
        System.out.println(set1);
        System.out.println(set1.equals(set2));

        Person satya = new Person("Satya", 20);
        HashSet<Person> set3 = new HashSet<Person>(
            Arrays.asList(
                 satya,
                 new Person("Sai", 21),
                 new Person("Neelapala", 22),
                 new Person("Jai", 23),
                 new Person("Jay", 24),
                 satya
                 )
            );
        System.out.println(set3);
    }
}
