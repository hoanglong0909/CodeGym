import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(100,"A");
        map.put(10,"B");
        map.put(1120,"A");
        map.put(1022,"c");
        Set<Integer> set = map.keySet();
        for(Integer key:set){
            System.out.println(key + "  " +map.get(key)
            );
        }
        System.out.println("*****************");
        for (Map.Entry<Integer,String>entry:
        map.entrySet()){
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }
    }

}
