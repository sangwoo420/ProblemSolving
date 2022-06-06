import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        int left = 0, right = 0, length = Integer.MAX_VALUE;
        while(sum < S && right < N) {
            sum += arr[right];
            if(sum >= S) {
                while(sum >= S) {
                    sum -= arr[left++];
                }
                int current = right - left + 2;
                length = length > current ? current : length;
            }
            right++;
        }
        System.out.println(length == Integer.MAX_VALUE ? 0 : length);
    }
}
