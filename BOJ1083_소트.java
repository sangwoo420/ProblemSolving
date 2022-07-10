import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1083_소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int S = Integer.parseInt(input.readLine());
        int start = 0;
        while (S > 0) {
            int max = -1, position = -1;
            for (int i = start; i <= start + S && i < N; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    position = i;
                }
            }
            if (max == -1) {
                break;
            }
            for (int i = position; i >= start + 1; i--) {
                int tmp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = tmp;
                S--;
            }
            start++;
        }
        StringBuilder answer = new StringBuilder();
        for (int num : arr) {
            answer.append(num).append(" ");
        }
        System.out.println(answer);
    }
}
