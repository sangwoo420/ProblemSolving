import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2623_음악프로그램 {
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
            int[] arr = new int[Integer.parseInt(st.nextToken())];
            for (int j = 0; j < arr.length; j++) arr[j] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < arr.length - 1; j++) {
                if (!nodes[arr[j]].children.contains(arr[j + 1])) {
                    nodes[arr[j]].children.add(arr[j + 1]);
                    nodes[arr[j + 1]].inDegree++;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (nodes[i].inDegree == 0) {
                q.offer(i);
            }
        }
        Queue<Integer> answerQueue = new LinkedList<>();
        while (!q.isEmpty()) {
            int current = q.poll();
            answerQueue.offer(current);
            for (int child : nodes[current].children) {
                nodes[child].inDegree--;
                if (nodes[child].inDegree == 0) {
                    q.offer(child);
                }
            }
        }
        if(answerQueue.size() != N) {
            System.out.println(0);
        } else {
            StringBuilder answer = new StringBuilder();
            while(!answerQueue.isEmpty()) {
                answer.append(answerQueue.poll()).append("\n");
            }
            System.out.println(answer);
        }
    }
}
