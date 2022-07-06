import java.math.BigInteger;
import java.util.Scanner;

public class BOJ1212_8진수2진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger octal = sc.nextBigInteger(8);
        System.out.println(octal.toString(2));
    }
}
