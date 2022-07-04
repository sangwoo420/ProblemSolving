import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1461_도서관 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int answer = 0;
        if (Math.abs(list.get(0)) > Math.abs(list.get(list.size() - 1))) {
            answer += Math.abs(list.get(0));
            int count = 0;
            while (!list.isEmpty() && list.get(0) < 0 && count < M) {
                list.remove(0);
                count++;
            }

        } else {
            answer += Math.abs(list.get(list.size() - 1));
            if (list.size() == 1) {
                list.remove(0);
            }
            int count = 0;
            while (!list.isEmpty() && list.get(list.size() - 1) > 0 && count < M) {
                list.remove(list.size() - 1);
                count++;
            }
        }
        while (!list.isEmpty()) {
            if (Math.abs(list.get(0)) > Math.abs(list.get(list.size() - 1))) {
                answer += 2 * Math.abs(list.get(0));
                int count = 0;
                while (!list.isEmpty() && list.get(0) < 0 && count < M) {
                    list.remove(0);
                    count++;
                }
            } else {
                answer += 2 * Math.abs(list.get(list.size() - 1));
                if (list.size() == 1) {
                    list.remove(0);
                    break;
                }
                int count = 0;
                while (!list.isEmpty() && list.get(list.size() - 1) > 0 && count < M) {
                    list.remove(list.size() - 1);
                    count++;
                }
            }
        }
        System.out.println(answer);
    }
}
