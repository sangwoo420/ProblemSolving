import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10942_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] isPalindrome = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) isPalindrome[i][i] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                int length = i + 1;
                if (length == 2) {
                    isPalindrome[j][j + i] = arr[j] == arr[j + i];
                } else {
                    isPalindrome[j][j + i] = arr[j] == arr[j + i] && isPalindrome[j + 1][j + i - 1];
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        int M = Integer.parseInt(input.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            answer.append(isPalindrome[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] ? 1 : 0).append("\n");
        }
        System.out.println(answer);
    }
}
