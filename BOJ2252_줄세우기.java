import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2252_줄세우기 {

    private static class Node {
        int inDegree;
        List<Integer> children;

        Node() {
            inDegree = 0;
            children = new ArrayList<>();
        }
    }

    private static StringBuilder answer = new StringBuilder();
    private static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) nodes[i] = new Node();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int parent = Integer.parseInt(st.nextToken()), child = Integer.parseInt(st.nextToken());
            if (!nodes[parent].children.contains(child)) {
                nodes[parent].children.add(child);
                nodes[child].inDegree++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (nodes[i].inDegree == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int current = q.poll();
            answer.append(current).append(" ");
            for (int child : nodes[current].children) {
                nodes[child].inDegree--;
                if (nodes[child].inDegree == 0) {
                    q.offer(child);
                }
            }
        }
        System.out.println(answer);
    }

}
