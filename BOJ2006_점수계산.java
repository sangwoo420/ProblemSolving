import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2006_점수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] problems = new int[N];
        for(int i = 0; i < N; i++) {
            problems[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0, score = 1;
        for(int i = 0; i < N; i++) {
            if(problems[i] == 1) {
                answer += score++;
            } else {
                score = 1;
            }
        }
        System.out.println(answer);
    }
}
