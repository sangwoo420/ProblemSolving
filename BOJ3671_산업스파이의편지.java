import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ3671_산업스파이의편지 {
    private static Map<Integer, Boolean> visitMap;
    private static boolean[] isNotPrime, using;
    private static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(input.readLine());
        isNotPrime = new boolean[10000000];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < Math.sqrt(10000000); i++) {
            if(!isNotPrime[i]) {
                for(int j = i + i; j < 10000000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int c = 0; c < C; c++) {
            visitMap = new HashMap<>();
            s = input.readLine();
            for (int i = 1; i <= s.length(); i++) {
                using = new boolean[s.length()];
                permutation("", 0, i);
            }

            answer.append(visitMap.size()).append("\n");
        }
        System.out.println(answer);
    }

    private static void permutation(String p, int depth, int r) {
        if (depth == r) {
            int num = Integer.parseInt(p);
            if (!isNotPrime[num]) {
                visitMap.put(num, true);
            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!using[i]) {
                using[i] = true;
                permutation(p + s.charAt(i), depth + 1, r);
                using[i] = false;
            }
        }
    }
}
