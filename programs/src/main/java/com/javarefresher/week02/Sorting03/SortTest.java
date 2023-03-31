package com.javarefresher.week02.Sorting03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SortTest {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(8, 1, 7, 2, 6, 5));
        arr.add(10);
        System.out.println("Before Sorting: "+ arr);
        Collections.sort(arr);
        System.out.println("After Sorting: " + arr);
        Collections.sort(arr, Collections.reverseOrder());
        System.out.println("After Sorting: " + arr);
    }
}
