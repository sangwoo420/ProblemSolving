import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15591_MooTubeSilver {


    private static int N, Q;
    private static List<Integer>[] adjList;
    private static int[][] similarities;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        adjList = new List[N + 1];
        similarities = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
            similarities[from][to] = similarities[to][from] = w;
        }
        bfs();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(input.readLine());
            int K = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (similarities[j][v] >= K) {
                    count++;
                }
            }
            answer.append(count).append("\n");
        }
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int start = 1; start <= N; start++) {
            boolean[] v = new boolean[N + 1];
            v[start] = true;
            q.offer(new int[]{start, Integer.MAX_VALUE});
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                int current = tmp[0], w = tmp[1];
                for (int next : adjList[current]) {
                    if (!v[next]) {
                        v[next] = true;
                        similarities[start][next] = Math.min(similarities[current][next], w);
                        q.offer(new int[]{next, similarities[start][next]});
                    }
                }
            }
        }
    }
}
