import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14221_편의점 {
    private static class Node {
        int v, w;
        Node link;

        Node(int v, int w, Node link) {
            this.v = v;
            this.w = w;
            this.link = link;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Node[] adjList = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, w, adjList[from]);
            adjList[to] = new Node(from, w, adjList[to]);
        }
        st = new StringTokenizer(input.readLine());
        int P = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        boolean[] isHome = new boolean[N + 1];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < P; i++) {
            isHome[Integer.parseInt(st.nextToken())] = true;
        }
        st = new StringTokenizer(input.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        }));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < Q; i++) {
            int cvs = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{cvs, 0});
            dist[cvs] = 0;
        }
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int current = tmp[0], totalDist = tmp[1];
            if (isHome[current]) {
                System.out.println(current);
                return;
            }
            for (Node next = adjList[current]; next != null; next = next.link) {
                if (dist[next.v] > totalDist + next.w) {
                    dist[next.v] = totalDist + next.w;
                    pq.offer(new int[]{next.v, totalDist + next.w});
                }
            }
        }
    }
}
