import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1082_방번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int[] costs = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(input.readLine());
        int min = Integer.MAX_VALUE, minNum = -1;
        for (int i = 1; i < N; i++) {
            if (min > costs[i]) {
                min = costs[i];
                minNum = i;
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(minNum);
        M -= min;
        if(M < 0) {
            System.out.println(0);
            return;
        }
        min = Integer.MAX_VALUE;
        minNum = -1;
        for (int i = 0; i < N; i++) {
            if (min > costs[i]) {
                min = costs[i];
                minNum = i;
            }
        }
        while (M >= min) {
            answer.append(minNum);
            M -= min;
        }
        for (int i = 0; i < answer.length(); i++) {
            for (int j = N - 1; j >= 0; j--) {
                int n = answer.charAt(i) - '0';
                if (j > n && M - Math.abs(costs[j] - costs[n]) >= 0) {
                    M -= Math.abs(costs[j] - costs[n]);
                    answer.setCharAt(i, Character.forDigit(j, 10));
                }
            }
        }
        System.out.println(answer);
    }
}
