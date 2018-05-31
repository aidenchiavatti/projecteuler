public class p006 {

    public static void main(String[] args) {
        //sum of the squares of the first one hundred natural numbers
        int sumOfSquare = sumOfSquare(100);
        //square of the sum
        int sum = 100*(100+1) / 2;
        int squareOfSum = sum * sum;
        System.out.println(squareOfSum - sumOfSquare);
    }

    private static int sumOfSquare(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i*i;
        }
        return sum;
    }
}
