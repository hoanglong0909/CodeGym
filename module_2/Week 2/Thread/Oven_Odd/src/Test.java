public class Test {
    public static void main(String[] args) {
      Even l1 = new Even();
      Thread t1 = new Thread(l1);
      Odd  t2 = new Odd();
      t1.start();
      t2.start();
    }
}
