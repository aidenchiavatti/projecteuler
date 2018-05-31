import java.util.ArrayList;
import java.util.List;

public class p002 {
    private static List<Integer> fibs = new ArrayList<>();
    //1, 2, 3, 5, 8, 13, 21, 34, 55, 89

    //2 -> 3 (fib(2)+sum(1))
    //3 -> 6 (fib(3)+sum(2))
    //4 -> 11 (fib(4)+sum(3))
    //5 -> 19 (fib(5)+sum(4))

    public static void main(String[] args) {
        fibInit(4000000);
        System.out.println(fibs.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum());
    }

    public static void fibInit(int max) {
        fibs.add(1);
        fibs.add(2);
        for(int i = 3; i <= 100000000; i++) {
            int sum = fibs.get(i - 3) + fibs.get(i - 2);
            if(sum > max) {
                return;
            }
            fibs.add(sum);
        }
    }
}
