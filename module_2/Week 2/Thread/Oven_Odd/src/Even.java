public class Even implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 10 ; i++) {
            if(i%2 == 0){
                System.out.println("Số chãn: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
