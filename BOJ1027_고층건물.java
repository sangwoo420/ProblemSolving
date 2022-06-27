import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1027_고층건물 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int[] buildings = new int[N + 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        double[] gradients;
        for (int i = 1; i <= N; i++) {
            gradients = new double[N + 1];
            for (int j = 1; j < i; j++) {
                gradients[j] = (1.0 * buildings[i] - buildings[j]) / (i - j);
            }
            for (int j = i + 1; j <= N; j++) {
                gradients[j] = (1.0 * buildings[j] - buildings[i]) / (j - i);
            }
            int count = 0;
            double lastLeftGradient = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 1; j--) {
                if (gradients[j] < lastLeftGradient) {
                    count++;
                    lastLeftGradient = gradients[j];
                }
            }
            double lastRightGradient = Integer.MIN_VALUE;
            for (int j = i + 1; j <= N; j++) {
                if (gradients[j] > lastRightGradient) {
                    count++;
                    lastRightGradient = gradients[j];
                }
            }
            if (answer < count) {
                answer = count;
            }
        }
        System.out.println(answer);
    }
}
