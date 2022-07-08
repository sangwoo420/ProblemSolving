import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1394_암호 {
    private static final int DIVIDER = 900528;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String charSet = input.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charSet.length(); i++) {
            map.put(charSet.charAt(i), i + 1);
        }
        String password = input.readLine();
        long answer = 0;
        long base = 1;
        for (int i = password.length() - 1; i >= 0; i--) {
            answer += ((base % DIVIDER) * map.get(password.charAt(i))) % DIVIDER;
            base *= map.size();
            base %= DIVIDER;
            answer %= DIVIDER;
        }
        System.out.println(answer % DIVIDER);
    }
}
