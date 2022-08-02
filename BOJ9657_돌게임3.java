import java.util.Scanner;

public class BOJ9657_돌게임3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] winner = new String[N + 1];
        winner[1] = "SK";
        for (int i = 2; i <= N; i++) {
            if (i == 2) {
                winner[i] = "CY";
            } else if (i == 3 || i == 4) {
                winner[i] = "SK";
            } else if ("SK".equals(winner[i - 1]) && "SK".equals(winner[i - 3]) && "SK".equals(winner[i - 4])) {
                winner[i] = "CY";
            } else {
                winner[i] = "SK";
            }
        }
        System.out.println(winner[N]);
    }
}
