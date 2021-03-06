import java.util.ArrayList;
import java.util.List;

public class p007 {
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        initPrimes();
        System.out.println(primes.get(10000));
    }

    private static void initPrimes() {
        primes.add(2);
        primes.add(3);
        for(int i = 4; i < 1000000; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
    }

    private static boolean isPrime(long n) {
        if(n % 2 == 0) {
            return false;
        }

        for(int i : primes) {
            if(i*i > n) {
                return true;
            }
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
