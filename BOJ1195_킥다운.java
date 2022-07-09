import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1195_킥다운 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String part1 = input.readLine(), part2 = input.readLine();
        int[] arr = new int[part1.length() * 2 + part2.length()];
        int min = part1.length() + part2.length();
        for (int i = 0; i < part2.length(); i++) {
            arr[part1.length() + i] = Integer.parseInt(part2.charAt(i) + "");
        }
        for (int start = 0; start < part1.length() + part2.length() + 1; start++) { // part2 : part1.length() ~ part1.length() + part2.length() - 1
            boolean found = true;
            for (int i = 0; i < part1.length(); i++) {
                if (Integer.parseInt(part1.charAt(i) + "") + arr[start + i] > 3) {
                    found = false;
                    break;
                }
            }
            if (found) {
                min = Math.min(min, Math.max(start + part1.length() - 1, part1.length() + part2.length() - 1) - Math.min(start, part1.length()) + 1);
            }
        }
        System.out.println(min);
    }
}
