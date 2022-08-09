import java.util.Scanner;

public class BOJ1225_이상한곱셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next(), B = sc.next();
        long answer = 0;
        for(int i = 0; i < A.length(); i++) {
            for(int j = 0; j < B.length(); j++) {
                answer += (A.charAt(i) - '0') * (B.charAt(j) - '0');
            }
        }
        System.out.println(answer);
    }
}
