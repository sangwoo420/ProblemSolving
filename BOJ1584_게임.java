import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1584_게임 {
    private final static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int[][] map = new int[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
            for (int r = Math.min(x1, x2); r <= Math.max(x1, x2); r++) {
                for (int c = Math.min(y1, y2); c <= Math.max(y1, y2); c++) {
                    map[r][c] = 1;
                }
            }
        }
        int M = Integer.parseInt(input.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
            for (int r = Math.min(x1, x2); r <= Math.max(x1, x2); r++) {
                for (int c = Math.min(y1, y2); c <= Math.max(y1, y2); c++) {
                    map[r][c] = -1;
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int[][] visited = new int[501][501];
        for (int r = 0; r <= 500; r++) {
            Arrays.fill(visited[r], Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int r = tmp[0], c = tmp[1];
            if (r == 500 && c == 500) {
                if (answer > visited[r][c]) {
                    answer = visited[r][c];
                }
            }
            for (int d = 0; d < deltas.length; d++) {
                int nr = r + deltas[d][0], nc = c + deltas[d][1];
                if (nr >= 0 && nr <= 500 && nc >= 0 && nc <= 500 && map[nr][nc] >= 0 && visited[nr][nc] > visited[r][c] + map[nr][nc]) {
                    if (map[nr][nc] == 1) {
                        visited[nr][nc] = visited[r][c] + 1;
                        q.offer(new int[]{nr, nc});
                    } else {
                        visited[nr][nc] = visited[r][c];
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
