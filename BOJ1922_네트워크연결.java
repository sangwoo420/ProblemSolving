import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1922_네트워크연결 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int M = Integer.parseInt(input.readLine());
        StringTokenizer st;
        int[] parent = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{x, y, w});
        }
        long answer = 0;
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if(union(tmp[0], tmp[1], parent)) {
                answer += tmp[2];
            }
        }
        System.out.println(answer);
    }

    private static int findSet(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findSet(parent[x], parent);
    }

    private static boolean union(int x, int y, int[] parent) {
        int xRoot = findSet(x, parent), yRoot = findSet(y, parent);
        if (xRoot == yRoot) {
            return false;
        }
        parent[yRoot] = xRoot;
        return true;
    }
}
