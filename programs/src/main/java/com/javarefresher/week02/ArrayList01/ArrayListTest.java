package com.javarefresher.week02.ArrayList01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        System.out.println("Default size: " +  arrayList.size());
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.addAll(Arrays.asList(4, 5, 6, 7));

        System.out.println("Size: " + arrayList.size());

        arrayList.addAll(1, Arrays.asList(8, 9, 10, 11));
        
        System.out.println("Size: " + arrayList.size());
        
        System.out.println("0-th index before removing: " + arrayList.get(0));
        System.out.println(arrayList);
        arrayList.remove(0);
        System.out.println("0-th index after removing: " + arrayList.get(0));
        arrayList.removeAll(Arrays.asList(10, 9));
        System.out.println(arrayList);
    }
}
