public class p004 {
    public static void main(String[] args) {
        int maxSquare = 998001;
        for(int i = maxSquare; i > 1000; i--) {
            StringBuilder builder = new StringBuilder(String.valueOf(i));
            String s = builder.toString();
            if(s.equals(builder.reverse().toString())) {
                if(isDivisible(i)) {
                    System.out.println(i);
                    System.exit(0);
                }
            }
        }
    }

    private static boolean isDivisible(int n) {
        for(int i = 999; i > 99; i--) {
            if(n % i == 0 && n / i < 1000) {
                System.out.println("num1: " + i);
                return true;
            }
        }
        return false;
    }
}
