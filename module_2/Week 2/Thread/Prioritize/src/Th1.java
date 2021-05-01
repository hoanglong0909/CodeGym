public class Th1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println("A " + ptioritize.random());
            try {
                Thread.sleep(ptioritize.random1());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
