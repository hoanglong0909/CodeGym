

public class LazyPrimeFactorization implements Runnable{
    @Override
    public void run() {

            for(int i = 1; i < 100; ++i) {
                if (isprime(i)) {
                    System.out.println("Số nguyên tố LP: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

    }
    public static boolean isprime(int number) {
        if (number < 2) {
            return false;
        } else {
            for(int i = 0; i < number; ++i) {
                if (number % 2 == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

