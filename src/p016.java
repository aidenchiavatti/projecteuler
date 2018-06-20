import java.math.BigDecimal;

public class p016 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BigDecimal d = new BigDecimal(2).pow(1000);
        long sum = 0;
        for(int i = 0; i < d.toString().length(); i++) {
            sum += Character.getNumericValue(d.toString().charAt(i));
        }
        System.out.println(sum);
    }
}
