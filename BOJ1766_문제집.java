import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1766_문제집 {
    private static class Node {
        int inDegree;
        List<Integer> children;

        Node() {
            inDegree = 0;
            children = new LinkedList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) nodes[i] = new Node();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int parent = Integer.parseInt(st.nextToken()), child = Integer.parseInt(st.nextToken());
            nodes[parent].children.add(child);
            nodes[child].inDegree++;

        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (nodes[i].inDegree == 0) {
                pq.offer(i);
            }
        }
        StringBuilder answer = new StringBuilder();
        while (!pq.isEmpty()) {
            int current = pq.poll();
            answer.append(current).append(" ");
            for (int child : nodes[current].children) {
                nodes[child].inDegree--;
                if (nodes[child].inDegree == 0) {
                    pq.offer(child);
                }
            }
        }
        System.out.println(answer);
    }
}
