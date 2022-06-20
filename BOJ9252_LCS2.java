import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s1 = input.readLine(), s2 = input.readLine();
        int C = s1.length(), R = s2.length();
        int[][] lcs = new int[R + 1][C + 1];
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (s2.charAt(r - 1) == s1.charAt(c - 1)) {
                    lcs[r][c] = lcs[r - 1][c - 1] + 1;
                } else {
                    lcs[r][c] = Math.max(lcs[r - 1][c], lcs[r][c - 1]);
                }
            }
        }
        System.out.println(lcs[R][C]);
        if (lcs[R][C] != 0) {
            StringBuilder answer = new StringBuilder();
            for (int r = R, num = lcs[R][C]; r >= 1 && num >= 1; r--) {
                for (int c = C; c >= 1; c--) {
                    if (lcs[r][c] == num && lcs[r - 1][c - 1] == num - 1 && lcs[r][c - 1] == num - 1 && lcs[r - 1][c] == num - 1) {
                        answer.append(s1.charAt(c - 1));
                        num--;
                        break;
                    }
                }
            }
            System.out.println(answer.reverse());
        }
    }
}
