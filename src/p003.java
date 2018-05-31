import java.util.ArrayList;
import java.util.List;

public class p003 {
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        initPrimes();
        int num = findLargestPrime(600851475143L);
        System.out.println(num);
    }

    private static int findLargestPrime(long n) {
        int max = 0;
        for(int i : primes) {
            if(n % i == 0) {
                max = i;
            }
        }
        return max;
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
