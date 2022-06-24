import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10836_여왕벌 {
    private static final int[][] deltas = {{-1, 0}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for (int r = 0; r < N; r++) {
            Arrays.fill(arr[r], 1);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int index = N - 1;
            boolean upward = true;
            int[] counts = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            for (int n = 0; n < counts.length; n++) {
                for (int j = 0; j < counts[n]; j++) {
                    if (upward) {
                        arr[index--][0] += n;
                        if (index < 0) {
                            index = 1;
                            upward = false;
                        }
                    } else {
                        arr[0][index++] += n;
                    }
                }
            }

        }
        for (int r = 1; r < N; r++) {
            for (int c = 1; c < N; c++) {
                for (int d = 0; d < deltas.length; d++) {
                    int nr = r + deltas[d][0], nc = c + deltas[d][1];
                    arr[r][c] = Math.max(arr[r][c], arr[nr][nc]);
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                answer.append(arr[r][c]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

}
