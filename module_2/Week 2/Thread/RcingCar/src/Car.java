
import java.util.Random;

public class Car implements Runnable {
    private String name;

    public  Car(String name){
        this.name = name;
    }
    @Override
    public void run() {
        // Khởi tạo điểm start(hay km ban đầu)
        int runDistance = 0;
// Khởi tạo time bắt đầu cuộc đua
        long startTime = System.currentTimeMillis();
// Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy
        while (runDistance < Main.DISTANCE) {
            try{
                int speed = ( new Random().nextInt(50));
                // Tính quãng đường đã đi
                runDistance += speed;
                // Xây dựng đồ họa kết quả
                String log =  "|" ;
                int percentTravel = (runDistance * 100)/Main.DISTANCE ;
                for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
                    if (percentTravel >= i + Main.STEP) {
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + Main.STEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(Main.DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}