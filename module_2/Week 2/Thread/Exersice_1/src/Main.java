public class Main {
    public static void main(String[] args) {
        System.out.println("Start");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10;i++){
                    System.out.println("thread " + i);
                }
            }
        });
        t.start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j <10 ;j ++) {
                    System.out.println("thread 1 " +j);
                }
            }
        });
        t1.start();
        // Cachs 2:
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10 ; i++) {
                    System.out.println("tr " + i );
                }
            }
        }).start();

        //ruma:
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                System.out.println("tr 1 " + i );
            }
        }).start();

        System.out.println("end");

    }
}
