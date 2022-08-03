import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        List<Integer> A = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(input.readLine());
        List<Integer> B = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());
        long answer = 0;
        for(int i = 0; i < N; i++) {
            answer += A.get(i) * B.get(i);
        }
        System.out.println(answer);
    }
}
