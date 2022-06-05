import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16946_벽부수고이동하기4 {
    private static final int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static char[][] map;
    private static boolean[][] visited;
    private static int[][] area, areaNum;
    private static int N, M, areaIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        area = new int[N][M];
        areaNum = new int[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            map[r] = input.readLine().toCharArray();
        }
        areaIndex = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == '0' && !visited[r][c]) {
                    getArea(r, c);
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == '0') answer.append(0);
                else answer.append(getCount(r, c));
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static int getCount(int r, int c) {
        int count = 1;
        Map<Integer, Boolean> visitMap = new HashMap<>();
        for (int d = 0; d < deltas.length; d++) {
            int nr = r + deltas[d][0], nc = c + deltas[d][1];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visitMap.getOrDefault(areaNum[nr][nc], false)) {
                count += area[nr][nc];
                visitMap.put(areaNum[nr][nc], true);
            }
        }
        return count % 10;
    }

    private static void getArea(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        int count = 1;
        visited[r][c] = true;
        q.offer(new int[]{r, c});
        list.add(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int d = 0; d < deltas.length; d++) {
                int nr = tmp[0] + deltas[d][0], nc = tmp[1] + deltas[d][1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == '0') {
                    visited[nr][nc] = true;
                    count++;
                    q.offer(new int[]{nr, nc});
                    list.add(new int[]{nr, nc});
                }
            }
        }
        for (int[] coord : list) {
            area[coord[0]][coord[1]] = count;
            areaNum[coord[0]][coord[1]] = areaIndex;
        }
        areaIndex++;
    }
}
