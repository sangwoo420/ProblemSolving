import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// O(N^2)
public class BOJ11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] length = new int[N];
        for (int i = 0; i < N; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    length[i] = Math.max(length[j] + 1, length[i]);
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (answer < length[i]) {
                answer = length[i];
            }
        }
        System.out.println(answer);
    }
}
