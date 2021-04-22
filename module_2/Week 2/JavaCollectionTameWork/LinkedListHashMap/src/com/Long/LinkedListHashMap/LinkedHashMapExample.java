package com.Long.LinkedListHashMap;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,"Quang sida");
        linkedHashMap.put(2,"thiện sike");
        linkedHashMap.put(3,"han sida");
        linkedHashMap.put(4,"hai sida");
        System.out.println("Before remove: ");
        for (Map.Entry<Integer,String> entry:
                linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+" " + entry.getValue());
        }
        linkedHashMap.remove(3);
        for (Map.Entry<Integer,String> entry:
                linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+" " + entry.getValue());
        }

    }
}

//import java.util.LinkedHashMap;
//import java.util.Set;
//
//public class LinkedHashMapExample {
//    public static void main(String[] args) {
//        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<Integer,String>();
//        linkedHashMap.put(1,"Long cun");
//        linkedHashMap.put(2,"Hop cun");
//        linkedHashMap.put(3,"xicula cun");
//        System.out.println("Before renove: ");
//        show(linkedHashMap);
//        linkedHashMap.remove(3);
//        System.out.println("After remove: ");
//        show(linkedHashMap);
//    }
//
//    private static void show(LinkedHashMap<Integer, String> linkedHashMap) {
//       Set<Integer> keySet = linkedHashMap.keySet();
//       for (Integer key : keySet){
//           System.out.println(key + " " + linkedHashMap.get(key));
//       }
//    }
//}
