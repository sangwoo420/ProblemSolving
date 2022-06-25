import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7579_앱 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] infos = new int[N][2];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            infos[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(input.readLine());
        int limit = 0;
        for (int i = 0; i < N; i++) {
            infos[i][1] = Integer.parseInt(st.nextToken());
            limit += infos[i][1];
        }

        int[] leastMemories = new int[limit + 1];

        for(int i = 0; i < N; i++) {
            for(int j = limit; j >= infos[i][1]; j--) {
                leastMemories[j] = Math.max(leastMemories[j - infos[i][1]] + infos[i][0], leastMemories[j]);

            }
        }
        int index = -1;
        for(int i = 1; i <= limit; i++) {
            if(leastMemories[i] >= M) {
                index = i;
                break;
            }
        }
        System.out.println(index);
    }
}
