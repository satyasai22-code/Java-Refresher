package com.javarefresher.week01;
import java.util.Arrays;

/**
 * KthSmallestAndLargest
 */
public class KthSmallestAndLargest {

    public static Integer[] solve(Integer[] arr, int k){
        Arrays.sort(arr);
        return new Integer[]{arr[k - 1], arr[arr.length - k ]};
    }
    public static void main(String[] args) {
        Integer[] arr = {1, 4, 5, 7, 9};
        int k = 2;
        for(Integer i: solve(arr, k)){
            System.out.println(i);
        }
    }
}