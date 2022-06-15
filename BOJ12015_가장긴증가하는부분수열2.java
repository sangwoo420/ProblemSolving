import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12015_가장긴증가하는부분수열2 {
    private static int[] seq;
    private static List<Integer> lis;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        seq = new int[N];
        lis = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        lis.add(seq[0]);
        for(int i = 1; i < N; i++) {
            int index = binarySearch(seq[i]);
            if(index == lis.size()) {
                lis.add(seq[i]);
            } else {
                lis.set(index, seq[i]);
            }
        }
        System.out.println(lis.size());
    }
    private static int binarySearch(int target) {
        int start = 0, end = lis.size() - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(lis.get(mid) == target) {
                return mid;
            }
            else if(lis.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
