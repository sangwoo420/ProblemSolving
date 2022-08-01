import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9507_GenerationsOfTribbles {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        long[] koong = new long[68];
        koong[0] = koong[1] = 1;
        koong[2] = 2;
        koong[3] = 4;
        for (int i = 4; i <= 67; i++) {
            koong[i] = koong[i - 1] + koong[i - 2] + koong[i - 3] + koong[i - 4];
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            answer.append(koong[Integer.parseInt(input.readLine())]).append("\n");
        }
        System.out.println(answer);
    }
}
