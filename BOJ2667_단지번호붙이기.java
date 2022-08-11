import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667_단지번호붙이기 {
    private static final int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static List<Integer> districtList;
    private static char[][] map;
    private static boolean[][] visited;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        map = new char[N][];
        visited = new boolean[N][N];
        districtList = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            map[r] = input.readLine().toCharArray();
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == '1' && !visited[r][c]) {
                    bfs(r, c);
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(districtList.size()).append("\n");
        Collections.sort(districtList);
        for (int i : districtList) {
            answer.append(i).append("\n");
        }
        System.out.println(answer);
    }

    private static void bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        visited[startR][startC] = true;
        int count = 1;
        q.offer(new int[]{startR, startC});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int r = tmp[0], c = tmp[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + deltas[d][0], nc = c + deltas[d][1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == '1') {
                    visited[nr][nc] = true;
                    count++;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        districtList.add(count);
    }
}
