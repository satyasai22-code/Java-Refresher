package com.javarefresher.week02.Sorting03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.javarefresher.week02.Person;

class AgeComparator implements Comparator<Person>{  
    public int compare(Person s1, Person s2){  
        if(s1.getAge() == s2.getAge())  
            return 0;  
        else if(s1.getAge()>s2.getAge())  
            return 1;  
        return -1;  
    }
}  
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

        List<Person> persons = new ArrayList<Person>(    
            Arrays.asList(
                new Person("Sai", 21),
                new Person("Neelapala", 22),
                new Person("Jai", 23),
                new Person("Jay", 24)
            ));
        Collections.sort(persons, new AgeComparator());
        System.out.println(persons);
    }
}
