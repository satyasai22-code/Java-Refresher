package com.javarefresher.week02.HashMap06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.javarefresher.week02.Person;

public class HashMapTest {
    public static Map<String, Person> sortHashMapByValuesByTreeMap(Map<String, Person> map){
        TreeMap<String, Person> treeMap = new TreeMap<>(map);
        Map<String, Person> sortedMap = new LinkedHashMap<>();
        for (Entry<String, Person> pair : treeMap.entrySet()){
            sortedMap.put(pair.getKey(), pair.getValue());
            // System.out.print(pair.getKey() + " : " + pair.getValue() + " ");
        }
        return sortedMap;
    }
    public static Map<String, Person> sortUsingArray(Map<String, Person> map)
    {
        ArrayList<String> sortedKeys
            = new ArrayList<String>(map.keySet());
 
        Collections.sort(sortedKeys);
        Map<String, Person> sortedMap = new LinkedHashMap<>();
        for (String x : sortedKeys)
             sortedMap.put(x, map.get(x));
        return sortedMap;
    }
    public static void main(String[] args) {
        Map<String, Person> hashMap = new HashMap<>();
        hashMap.put("dab",   new Person("Jay", 24));
        hashMap.put("dac",  new Person("Sai", 21));
        hashMap.put("dacb", new Person("Satya", 20));
        hashMap.put("dacba", new Person("Jai", 23));
        hashMap.put("a",  new Person("Neelapala", 20));
        System.out.println("Before sorting: " + hashMap);
        System.out.println("After sorting: " +sortHashMapByValuesByTreeMap(hashMap));
        Map<String, Person> map = new HashMap<>();
        map.put("Jay",  new Person("Jay", 24));
        map.put("Abhiram",  new Person("Abhiram", 21));
        map.put("Anvesh", new Person("Anvesh", 20));
        map.put("Amit", new Person("Amit", 23));
        map.put("Satya", new Person("Neelapala", 20));
        System.out.println("Before sorting: " + map);
        System.out.println("After sorting using Treemap: " + sortHashMapByValuesByTreeMap(map));
        System.out.println("After sorting using ArrayList: " + sortUsingArray(map));
    }
}
