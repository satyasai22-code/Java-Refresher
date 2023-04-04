package com.javarefresher.week02.HashSet05;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4));

        HashSet<Integer> set2 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 1));


        System.out.println(set1.equals(set2));
        System.out.println(set1 == set2);
        set1.add(5);
        set2.add(5);

        System.out.println(set1.equals(set2));

        set1.remove(1);
        System.out.println(set1.equals(set2));
    }
}
