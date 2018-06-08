import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class p012 {
    public static void main(String[] args) {
        int i = 1;
        int lastFactors = 1;
        while(true) {
            int n;
            if(i % 2 == 0) {
                n = numberOfFactors(i + 1);
            } else {
                n = numberOfFactors((i + 1) / 2);
            }
            if(n * lastFactors > 500) {
                System.out.println(i*(i+1)/2);
                System.exit(0);
            }
            lastFactors = n;
            i++;
        }
    }

    public static int numberOfFactors(int n) {
        int cnt = 1;
        for(int i = 2; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    @Test
    public void testNumberOfFactors() {
        assertEquals(1, numberOfFactors(1));
        assertEquals(2, numberOfFactors(3));
        assertEquals(4, numberOfFactors(6));
        assertEquals(4, numberOfFactors(10));
        assertEquals(4, numberOfFactors(15));
        assertEquals(4, numberOfFactors(21));
        assertEquals(6, numberOfFactors(28));
    }
}
