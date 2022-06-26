import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1159_농구경기 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int[] initials = new int[26];
        for(int i = 0; i < N; i++) {
            String s = input.readLine();
            initials[s.charAt(0) - 'a']++;
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(initials[i] >= 5) {
                answer.append((char)('a' + i));
            }
        }
        if(answer.length() > 0) {
            System.out.println(answer);
        } else {
            System.out.println("PREDAJA");
        }
    }
}
