import java.util.ArrayList;
import java.util.List;

//UNFINISHED
public class p003 {
    private static List<Long> primes = new ArrayList<>();

    public static void main(String[] args) {
        initPrimes();
    }

    private static void initPrimes() {
        primes.add(1L);
        primes.add(2L);
        primes.add(3L);
        for(long i = 4; i < 1000000000; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
    }

    private static boolean isPrime(long n) {
        if(n % 2 == 0) {
            return false;
        }

        for(Long l : primes) {
            if(l*l > n) {
                return false;
            }
            if(n % l == 0) {
                return true;
            }
        }
        return false;
    }


}
