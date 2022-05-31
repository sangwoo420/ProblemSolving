import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197_최소스패닝트리 {
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
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
        Node[] adjList = new Node[V + 1];
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, w, adjList[from]);
            adjList[to] = new Node(from, w, adjList[to]);
        }
        int answer = 0;
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        pq.offer(new Node(1, 0, null));
        while(!pq.isEmpty()) {
            Node tmp = pq.poll();
            if(visited[tmp.v]) continue;
            visited[tmp.v] = true;
            answer += tmp.w;
            for(Node next = adjList[tmp.v]; next != null; next = next.link) {
                if(!visited[next.v]) {
                    pq.offer(next);
                }
            }
        }
        System.out.println(answer);
    }
}
