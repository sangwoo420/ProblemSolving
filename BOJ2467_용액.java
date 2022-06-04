import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int minIndex = 0, maxIndex = N - 1;
        int a = -1, b = -1;
        int min = Integer.MAX_VALUE;
        while(minIndex < maxIndex) {
            int tmp = arr[maxIndex] + arr[minIndex];
            if(min >= Math.abs(tmp)) {
                min = Math.abs(tmp);
                a = minIndex;
                b = maxIndex;
            }
            if(tmp > 0) maxIndex--;
            else if(tmp < 0) minIndex++;
            else break;
        }
        System.out.println(arr[a] + " " + arr[b]);
    }
}
