import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2166_다각형의면적 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st;
        long[][] points = new long[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        double answer = 0;
        for (int i = 0; i < N; i++) {
            answer += (points[i % N][0] + points[(i + 1) % N][0]) * (points[i % N][1] - points[(i + 1) % N][1]);
        }
        answer = Math.abs(answer);
        answer /= 2;
        System.out.printf("%.1f", answer);
    }
}
