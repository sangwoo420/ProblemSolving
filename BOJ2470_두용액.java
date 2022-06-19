import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int minIndex = 0, maxIndex = N - 1;
        int a = -1, b = -1;
        int min = Integer.MAX_VALUE;
        while (minIndex < maxIndex) {
            int tmp = list.get(maxIndex) + list.get(minIndex);
            if (min >= Math.abs(tmp)) {
                min = Math.abs(tmp);
                a = minIndex;
                b = maxIndex;
            }
            if (tmp > 0) maxIndex--;
            else if (tmp < 0) minIndex++;
            else break;
        }
        System.out.println(list.get(a) + " " + list.get(b));

    }
}
