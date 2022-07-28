import java.math.BigInteger;
import java.util.Scanner;

public class BOJ10826_피보나치수4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N == 0) {
            System.out.println(0);
            return;
        }
        BigInteger[] fibo = new BigInteger[N + 1];
        fibo[0] = BigInteger.ZERO;
        fibo[1] = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            fibo[i] = fibo[i - 1].add(fibo[i - 2]);
        }
        System.out.println(fibo[N]);
    }
}
