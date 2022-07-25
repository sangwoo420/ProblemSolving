import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_로봇청소기 {
    private static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // N E S W

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                answer++;
            }
            boolean available = false;
            for (int i = 1; i <= 4; i++) {
                int nr = r + deltas[(d - i + 4) % 4][0], nc = c + deltas[(d - i + 4) % 4][1];
                if (map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    d = (d - i + 4) % 4;
                    available = true;
                    break;
                }
            }
            if (available) {
                continue;
            }
            r -= deltas[d][0];
            c -= deltas[d][1];
            if (map[r][c] == 1) {
                break;
            }
        }
        System.out.println(answer);
    }
}
