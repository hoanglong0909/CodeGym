import java.util.Random;

public class ptioritize {
    public static int random(){
        Random rd = new Random();
        int rdrandom = rd.nextInt(100) + 10;
        return rdrandom;
    }
    public static int random1(){
        Random rd1 = new Random();
        return rd1.nextInt(2000) + 10;
    }



    public static void main(String[] args) {
        Th1 th1= new Th1();
        Th2 t1 = new Th2();
        Thread th2 = new Thread(t1);
        th1.start();
        th2.start();
    }

}
