public class Main {
    public static final int DISTANCE =  100;
    public static final int STEP = 2 ;

    public static void main(String[] args) {


        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");
        Car carD = new Car("D");

        Thread threadA = new Thread(carA);
        Thread threadB = new Thread(carB);
        Thread threadC = new Thread(carC);
        Thread threadD = new Thread(carD);

        System.out.println("DISTANCE 100 km ");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
