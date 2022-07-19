import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928_뱀과사다리게임 {
    private static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        map = new int[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[] v = new boolean[101];
        q.offer(new int[]{1, 0});
        v[1] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int current = tmp[0], count = tmp[1];
            if (current == 100) {
                return count;
            }
            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if (next <= 100 && !v[next]) {
                    if (map[next] == 0) {
                        v[next] = true;
                        q.offer(new int[]{next, count + 1});
                    } else {
                        v[next] = true;
                        v[map[next]] = true;
                        q.offer(new int[]{map[next], count + 1});
                    }
                }
            }
        }
        return -1;
    }
}
