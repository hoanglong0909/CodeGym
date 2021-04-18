import java.util.ArrayList;

public class TestArrList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(23);
        arrayList.add(31);
        arrayList.add(21);
        arrayList.add(-100);
        for(int i = 0 ; i < arrayList.size();i++) {
            System.out.println(arrayList.get(i));
        }


    }
}
