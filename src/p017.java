import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class p017 {

    public static String[] numbers = {
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "twenty", "thirty", "forty", "fifty", "sixty",
            "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i < 1000; i++) {
            sum += numLetters(i);
        }
        sum += 11; //'one thousand'
        System.out.println(sum);
    }

    public static int numLetters(int n) {
        //get hundreds string
        String hundreds = getHundredsString(n);

        //get tens string
        String tens = getTensString(n % 100);

        String total;
        //combine strings with spaces. if hundreds and tens, add 'and'
        if(!hundreds.isEmpty() && !tens.isEmpty()) {
            total =  hundreds + " and " + tens;
        } else {
            total = hundreds + tens;
        }
        return total.replace(" ", "").length();
    }

    public static String getHundredsString(int n) {
        if(n < 100) {
            return "";
        }
        return numbers[n / 100 - 1] + " hundred";
    }

    public static String getTensString(int n) {
        if(n == 0) {
            return "";
        }
        else if(n < 20) {
            return numbers[n - 1];
        } else {
            String s = getDigitString(n % 10);
            if(s.isEmpty()) {
                return tens[n / 10 - 2];
            } else {
                return tens[n / 10 - 2] + " " + getDigitString(n % 10);
            }
        }
    }

    public static String getDigitString(int n) {
        if(n == 0) {
            return "";
        } else {
            return numbers[n - 1];
        }
    }

    @Test
    public void testNumLetters() {
        assertEquals(3, numLetters(1));
        assertEquals(3, numLetters(2));
        assertEquals(5, numLetters(3));
        assertEquals(4, numLetters(4));
        assertEquals(3, numLetters(10));
        assertEquals(6, numLetters(11));
        assertEquals(9, numLetters(21)); //twenty one
        assertEquals(10, numLetters(100)); //one hundred
        assertEquals(19, numLetters(111)); //one hundred and eleven
        assertEquals(23, numLetters(342)); //three hundred and forty two
    }

    @Test
    public void testGetHundredsString() {
        assertEquals("", getHundredsString(1));
        assertEquals("one hundred", getHundredsString(100));
        assertEquals("nine hundred", getHundredsString(900));
    }

    @Test
    public void testGetTensString() {
        assertEquals("", getTensString(0));
        assertEquals("one", getTensString(1));
        assertEquals("twenty", getTensString(20));
        assertEquals("twenty one", getTensString(21));
        assertEquals("ninety nine", getTensString(99));
    }

    @Test
    public void testGetDigitString() {
        assertEquals("", getDigitString(0));
        assertEquals("one", getDigitString(1));
        assertEquals("nine", getDigitString(9));
    }
}
