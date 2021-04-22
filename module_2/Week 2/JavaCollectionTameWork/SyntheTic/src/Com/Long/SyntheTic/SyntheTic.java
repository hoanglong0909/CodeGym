package Com.Long.SyntheTic;

import java.util.HashMap;
import java.util.Map;

public class SyntheTic {
    public static void main(String[] args) {
        Map<Integer, String> hashmap = new HashMap<>();
        Map<Integer, String> linkedlistHashmap = new HashMap<>();
        Map<Integer, String> treemap = new HashMap<>();
        System.out.println("hashmap - trả về giá trị ngẫu nhiên");
        testmap(hashmap);
        System.out.println("************************************************");
        System.out.println("LinkedHashMap - Nhập vào sao thì in ra như vậy!");
        testmap(linkedlistHashmap);
        System.out.println("************************************************");
        System.out.println("TreeMap - Sắp xếp theo thứ tự tăng dần");
        testmap(treemap);
        System.out.println("************************************************");

    }
    public static void testmap(Map<Integer,String> test){
        test.put(11,"Duong");
        test.put(65,"Khanh");
        test.put(65,null);
        test.put(23,"Quang");
        test.put(43,"Long");
        test.put(44,null);
        test.put(32,"Han");
        test.put(91,null);
        test.put(20,"Nam");

        for(Integer key:
        test.keySet()){
            String value = test.get(key);
            System.out.println(key + "_____________"+ value);
        }

//        for (Map.Entry<Integer,String> entry:
//        test.entrySet()){
//            System.out.println(entry.getKey()+"____" +entry.getValue());
//        }
    }

}
