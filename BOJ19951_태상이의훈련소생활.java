import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19951_태상이의훈련소생활 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] heights = new int[N + 1];
        st = new StringTokenizer(input.readLine());
        for(int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[N + 2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
            sum[from] += h;
            sum[to + 1] -= h;
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i] + sum[i - 1];
            heights[i] += sum[i];
            answer.append(heights[i]).append(" ");
        }
        System.out.println(answer);
    }
}
