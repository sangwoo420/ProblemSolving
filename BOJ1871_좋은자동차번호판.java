import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1871_좋은자동차번호판 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine(), "-");
            String s1 = st.nextToken(), s2 = st.nextToken();
            int val = (int) Math.abs(Math.pow(26, 2) * (s1.charAt(0) - 'A') + 26 * (s1.charAt(1) - 'A') + (s1.charAt(2) - 'A') - Integer.parseInt(s2));
            if (val <= 100) {
                answer.append("nice");
            } else {
                answer.append("not nice");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}
