public class p005 {
    public static void main(String[] args) {
        int i = 2500;
        while(true) {
            if(isDivisible(i)) {
                System.out.println(i);
                System.exit(0);
            }
            i++;
        }
    }

    private static boolean isDivisible(int n) {
        for(int i = 11; i <= 20; i++) {
            if(n % i != 0) {
                return false;
            }
        }
        return true;
    }
}
