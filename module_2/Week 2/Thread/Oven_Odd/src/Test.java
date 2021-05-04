public class Test {
    public static void main(String[] args) throws InterruptedException {
      Even l1 = new Even();
      Thread t1 = new Thread(l1);

      Odd  t2 = new Odd();
      t1.start();
      t1.join();
        System.out.println("Đã hoàn thành chuỗi số chẵn");
      t2.start();
      t2.join();
        System.out.println("Đã hoàn thành chuỗi số lẻ");
    }
}
