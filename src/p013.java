import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p013 {
    //first 10 digits of 100 50-digits nums

    //first digit -> 5*100 = 500 (avg), max of 900
    //first 8 digits -> 55555555 * 100 = 5555555500

    //lets try first 12 digits to be safe, accounts for all of carries

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("p013.txt"))) {
            long total = 0;
            while(scanner.hasNextLine()) {
                total += Long.parseLong(scanner.nextLine().substring(0, 12));
            }
            String s = String.valueOf(total);
            System.out.println(s.substring(0, 10));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
