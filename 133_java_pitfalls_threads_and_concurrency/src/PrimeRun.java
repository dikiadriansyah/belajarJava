public class PrimeRun implements Runnable {
    long minPrime;

    PrimeRun(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        System.out.println("Computing primes larger than " + minPrime);
        long num = minPrime;
        while (true) {
            if (isPrime(num)) {
                System.out.println(num + " is prime");
            }
            num++;
        }
    }

    // Method to check if a number is prime
    private boolean isPrime(long n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
