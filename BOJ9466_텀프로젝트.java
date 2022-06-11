import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9466_텀프로젝트 {
    private static int[] selects, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(input.readLine());
            selects = new int[N + 1];
            visited = new int[N + 1];
            st = new StringTokenizer(input.readLine());
            for (int i = 1; i <= N; i++) {
                selects[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    visited[i]++;
                    int next = selects[i];
                    while (visited[next] != -1 && visited[next] <= 1) {
                        visited[next]++;
                        next = selects[next];
                    }
                    if (visited[next] == -1) {
                        next = i;
                        while (visited[next] != -1) {
                            visited[next] = -1;
                            next = selects[next];
                        }
                    } else {
                        next = i;
                        while (visited[next] != 2) {
                            visited[next] = -1;
                            next = selects[next];
                        }
                    }
                }
            }
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (visited[i] <= 1) count++;
            }
            answer.append(count).append("\n");
        }
        System.out.println(answer);
    }
}
