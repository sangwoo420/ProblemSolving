import java.math.BigInteger;
import java.util.Scanner;

public class BOJ2407_조합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        BigInteger[] fact = new BigInteger[N + 1];
        fact[0] = BigInteger.ONE;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i));
        }
        System.out.println(fact[N].divide(fact[N - M].multiply(fact[M])));
    }
}
