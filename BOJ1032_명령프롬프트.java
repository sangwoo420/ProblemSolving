import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1032_명령프롬프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringBuilder initialString = new StringBuilder(input.readLine());
        for(int i = 1; i < N; i++) {
            String s = input.readLine();
            for(int j = 0; j < s.length(); j++) {
                if(initialString.charAt(j) != s.charAt(j)) {
                    initialString.setCharAt(j, '?');
                }
            }
        }
        System.out.println(initialString);
    }
}
