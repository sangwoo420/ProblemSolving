import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1547_공 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st;
        int[] cups = new int[4];
        cups[1] = 1;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            swap(cups, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i = 1; i <= 3; i++) {
            if(cups[i] != 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
