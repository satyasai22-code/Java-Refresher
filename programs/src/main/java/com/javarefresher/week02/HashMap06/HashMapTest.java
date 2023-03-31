package com.javarefresher.week02.HashMap06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapTest {
    public static Map<String, Integer> sortHashMapByValuesByTreeMap(Map<String, Integer> map){
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> pair : treeMap.entrySet()){
            sortedMap.put(pair.getKey(), pair.getValue());
            // System.out.print(pair.getKey() + " : " + pair.getValue() + " ");
        }
        return sortedMap;
    }
    public static Map<String, Integer> sortUsingArray(Map<String, Integer> map)
    {
        ArrayList<String> sortedKeys
            = new ArrayList<String>(map.keySet());
 
        Collections.sort(sortedKeys);
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (String x : sortedKeys)
             sortedMap.put(x, map.get(x));
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
        map.put("Jay", 80);
        map.put("Abhiram", 90);
        map.put("Anvesh", 80);
        map.put("Amit", 75);
        map.put("Satya", 40);
        System.out.println("Before sorting: " + map);
        System.out.println("After sorting using Treemap: " + sortHashMapByValuesByTreeMap(map));
        System.out.println("After sorting using ArrayList: " + sortUsingArray(map));
    }
}
