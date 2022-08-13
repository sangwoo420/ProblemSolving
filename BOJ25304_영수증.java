import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25304_영수증 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(input.readLine());
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            sum += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }
        System.out.println(X == sum ? "Yes" : "No");
    }
}
