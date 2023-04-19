package com.javarefresher.week04;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

// Program to Print Even Numbers, Duplicates and maximum number in the given list

public class Question010205 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        // Question - 01
        // Print even Numbers
        System.out.println("----------Print Even Numbers--------------");
        numbers.stream()
        .filter(value -> value % 2 == 0)
        .forEach(System.out::println);

        //Question - 02
        //Print Duplicate numbers
        System.out.println("----------Print Duplicate Numbers--------------");
        numbers.stream().filter(i -> Collections.frequency(numbers, i) >1)
        .collect(Collectors.toSet())
        .forEach(System.out::println);

        //Question - 05
        //Find Maximum Number in the given list
        System.out.println("----------Print Maximum Numbers--------------");
        OptionalInt maxUsingOptionalInt = numbers.stream().mapToInt(Integer::intValue).max(); //Converting to IntStream
        Optional<Integer> maxUsingReduce = numbers.stream().reduce(Integer::max); //Using Reduce method

        System.out.println(maxUsingOptionalInt.getAsInt() + " " + maxUsingReduce.get()) ;




    }
}
