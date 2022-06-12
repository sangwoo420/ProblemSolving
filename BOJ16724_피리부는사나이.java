import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16724_피리부는사나이 {
    private static int[][][] visited;
    private static char[][] map;
    private static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N][M][2];

        map = new char[N][M];
        for (int r = 0; r < N; r++) {
            map[r] = input.readLine().toCharArray();
            for (int c = 0; c < M; c++) {
                visited[r][c] = new int[]{-1, -1};
            }
        }
        answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c][0] == -1 && visited[r][c][1] == -1) {
                    dfs(r, c, r, c);
                }
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int r, int c, int parentR, int parentC) {
        if (r < 0 || r == N || c < 0 || c == M) {
            return;
        }
        if (visited[r][c][0] == parentR && visited[r][c][1] == parentC) {
            answer++;
            return;
        } else if (visited[r][c][0] >= 0 && visited[r][c][1] >= 0) {
            return;
        }
        visited[r][c][0] = parentR;
        visited[r][c][1] = parentC;
        switch (map[r][c]) {
            case 'U':
                dfs(r - 1, c, parentR, parentC);
                break;
            case 'D':
                dfs(r + 1, c, parentR, parentC);
                break;
            case 'L':
                dfs(r, c - 1, parentR, parentC);
                break;
            case 'R':
                dfs(r, c + 1, parentR, parentC);
                break;
        }
    }
}
