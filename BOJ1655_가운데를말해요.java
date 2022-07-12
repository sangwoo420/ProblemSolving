import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1, o2) * -1));
        PriorityQueue<Integer> right = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1, o2)));
        StringBuilder answer = new StringBuilder();
        left.offer(Integer.parseInt(input.readLine()));
        answer.append(left.peek()).append("\n");
        int mid = left.peek();
        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(input.readLine());
            if ((left.size() + right.size()) % 2 == 0 || left.size() > right.size()) {
                mid = left.peek();
            } else {
                mid = right.peek();
            }
            if (n > mid) {
                right.offer(n);
            } else {
                left.offer(n);
            }
            if ((left.size() + right.size()) % 2 == 0) {
                if (left.size() > right.size()) {
                    right.offer(left.poll());
                } else if (left.size() < right.size()) {
                    left.offer(right.poll());
                }
                answer.append(left.peek()).append("\n");
            } else {
                if (left.size() > right.size()) {
                    answer.append(left.peek()).append("\n");
                } else if (left.size() < right.size()) {
                    answer.append(right.peek()).append("\n");
                }
            }
        }
        System.out.println(answer);
    }
}
