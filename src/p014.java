import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class p014 {
    public static void main(String[] args) {
        int max = 0;
        int starter = 0;
        for(int i = 2; i < 1000000; i++) {
            int length = lengthOfSequence(i);
            if(length > max) {
                max = length;
                starter = i;
            }
        }
        System.out.println(starter);
    }

    public static int lengthOfSequence(long n) {
        int cnt = 1;
        while(n > 1) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            cnt++;
        }
        return cnt;
    }

    @Test
    public void testLengthOfSequence() {
        assertEquals(10, lengthOfSequence(13));
        assertEquals(525, lengthOfSequence(837799));
    }
}
