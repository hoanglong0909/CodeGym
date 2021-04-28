public class Test1 {
    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        Thread t2 = new Thread(new ThreadTwo(t1));
        System.out.println("Thread main start ");
        t1.start();
        t2.start();
        System.out.println("Thread main stop ");
    }
}
