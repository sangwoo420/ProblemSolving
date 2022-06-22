import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2437_세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        long min = Long.MAX_VALUE;
        int[] answers = {};
        boolean found = false;
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1, right = N - 1;
            while (left < right) {
                long sum = 0;
                sum += list.get(i);
                sum += list.get(left);
                sum += list.get(right);
                System.out.println(sum);
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    answers = new int[]{list.get(i), list.get(left), list.get(right)};
                }
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        System.out.println(answers[0] + " " + answers[1] + " " + answers[2]);
    }

}
