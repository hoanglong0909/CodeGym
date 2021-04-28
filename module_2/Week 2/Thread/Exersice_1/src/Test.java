public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread main start ");
        ThreadOne threadOne = new ThreadOne();
        threadOne.setName("A");
        threadOne.start();
        System.out.println("thực hiện join 1 vào main ");
        threadOne.join();

        ThreadTwo threadTwo = new ThreadTwo();
        Thread  T = new Thread(threadTwo);
        T.start();


        System.out.println("thực hiện join 2 vào main ");
        T.join();
        System.out.println("Thread main Stop ");

//        try {
//            Thread.sleep(5000);
//            threadOne.stop();
//            T.stop();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
