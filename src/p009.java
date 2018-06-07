public class p009 {
    public static void main(String[] args) {
        for(int i = 1; i < 1000; i++) {
            for(int j = 1; j < 1000; j++) {
                if(sumMatches(j, i)) {
                    System.out.printf("a: %s, b: %s, c: %s%n", i, j, Math.sqrt(i*i + j*j));
                    System.out.println(i*j*Math.sqrt(i*i + j*j));
                }
            }
        }
    }

    public static boolean sumMatches(int a, int b) {
        return a + b + Math.sqrt(a*a + b*b) == 1000;
    }
}
