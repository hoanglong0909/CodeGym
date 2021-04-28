import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        List <String> list = new ArrayList<String>();
        list.add("java");
        list.add("php");
        list.add("c#");
        list.add(1, "c++");
        System.out.println("phaanf twr cos index 2 = " + list.get(2));
        for (String index: list
        ) {
            System.out.println(index);

        }

    }

}
