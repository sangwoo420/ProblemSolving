import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1049_기타줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            pq1.offer(Integer.parseInt(st.nextToken()));
            pq2.offer(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        if (N >= 6) {
            answer += Math.min((N / 6) * pq1.peek(), (N / 6) * pq2.peek() * 6);
            N %= 6;
        }
        if (N > 0) {
            answer += Math.min(N * pq2.poll(), pq1.poll());
        }
        System.out.println(answer);
    }
}
