package com.javarefresher.week02.HashMap06;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapTest {
    public static Map<String, Integer> sortHashMapByValuesByTreeMap(Map<String, Integer> map){
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> pair : treeMap.entrySet()){
            sortedMap.put(pair.getKey(), pair.getValue());
            // System.out.print(pair.getKey() + " : " + pair.getValue() + " ");
        }
        // System.out.println();
        return sortedMap;
    }
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("dab", 100);
        hashMap.put("dac", 98);
        hashMap.put("dacb", 99);
        hashMap.put("dacba", 99);
        hashMap.put("a", 97);
        System.out.println("Before sorting: " + hashMap);
        System.out.println("After sorting: " +sortHashMapByValuesByTreeMap(hashMap));
        Map<String, Integer> map = new HashMap<>();
        map.put("Jayant", 80);
        map.put("Abhishek", 90);
        map.put("Anushka", 80);
        map.put("Amit", 75);
        map.put("Danish", 40);
        System.out.println("Before sorting: " + map);
        System.out.println("After sorting: " +sortHashMapByValuesByTreeMap(map));
    }
}
