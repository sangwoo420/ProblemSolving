import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14003_가장긴증가하는부분수열5 {
    private static int[] seq, indexes;
    private static List<Integer> lis;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        seq = new int[N];
        indexes = new int[N];
        lis = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        lis.add(seq[0]);
        indexes[0] = 1;
        for (int i = 1; i < N; i++) {
            int index = binarySearch(seq[i]);
            if(index == lis.size()) {
                lis.add(seq[i]);
            } else {
                lis.set(index, seq[i]);
            }
            indexes[i] = index + 1;
        }
        StringBuilder answer = new StringBuilder();
        answer.append(lis.size()).append("\n");
        Stack<Integer> stk = new Stack<>();
        for(int i = N - 1, j = lis.size(); i >= 0 && j >= 1; i--) {
            if(indexes[i] == j) {
                stk.push(seq[i]);
                j--;
            }
        }
        while (!stk.isEmpty()) {
            answer.append(stk.pop()).append(" ");
        }
        System.out.println(answer);
    }

    private static int binarySearch(int target) {
        int start = 0, end = lis.size() - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == lis.get(mid)) {
                return mid;
            } else if (target < lis.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
