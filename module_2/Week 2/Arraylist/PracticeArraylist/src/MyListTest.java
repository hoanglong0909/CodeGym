public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> array = new MyList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(3,2);
        for (int i = 0; i < array.getSize(); i++) {
            System.out.println(array.get(i));
        }
    }
}
