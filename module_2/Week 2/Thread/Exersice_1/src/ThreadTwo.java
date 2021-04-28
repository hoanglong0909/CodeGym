public class ThreadTwo implements Runnable {
    ThreadOne t1;

    public ThreadTwo(ThreadOne t1) {
        this.t1 = t1;
    }

    public ThreadTwo() {

    }


    public ThreadOne getT1() {
        return t1;
    }

    public void setT1(ThreadOne t1) {
        this.t1 = t1;
    }


    @Override
    public void run() {
        System.out.println("t2 is running ");
        try {
            System.out.println("join t1 into t2 ");
            t1.join();
            System.out.println("t1 finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10 ; i++) {
            System.out.println("two " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
