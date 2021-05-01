public class Test {
    public static void main(String[] args) {
        LazyPrimeFactorization l1 = new LazyPrimeFactorization();
        Thread t1 = new Thread(l1);
        OptimizedPrimeFactorization l2 = new OptimizedPrimeFactorization();
        Thread t2 = new Thread(l2);
        t1.start();
        t2.start();

    }
}
