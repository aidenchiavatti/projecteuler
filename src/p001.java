public class p001 {
    public static void main(String[] args) {
        //trivial solution. O(n)
        int sum = 0;
        for(int i = 1; i < 1000; i++) {
            if(i % 5 == 0 || i % 3 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);

        //better solution. O(1)
        int n = 999;
        int mult3 = n / 3;
        int mult5 = n / 5;
        int mult15 = n / 15;

        int sum3 = 3 * summation(mult3);
        int sum5 = 5 * summation(mult5);
        int sum15 = 15 * summation(mult15);
        System.out.println(sum3 + sum5 - sum15);
    }

    public static int summation(int n) {
        return n * (n + 1) / 2;
    }
}
