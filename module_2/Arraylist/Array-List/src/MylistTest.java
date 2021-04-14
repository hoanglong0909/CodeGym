public class MylistTest {

        public static void main(String[] args) {
            MyList<Integer> ll = new MyList<Integer>();
            ll.add(1);
            ll.add(2);
            ll.add(3);
            ll.add(4);
            ll.add(5);
            ll.add(3,9);
            ll.remote(4);
            System.out.println(ll.contains(3));
            ll.display();


        }
}
