import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1205_등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), newScore = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
        List<Integer> ranks = new LinkedList<>();
        if (N > 0) {
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < N; i++) {
                ranks.add(Integer.parseInt(st.nextToken()));
            }
        }
        boolean updated = false;
        for (int i = 0; i < ranks.size(); i++) {
            if (ranks.get(i) < newScore) {
                ranks.add(i, newScore);
                updated = true;
                break;
            }
        }
        if (!updated) {
            if (ranks.size() == P) {
                System.out.println(-1);
                return;
            } else {
                ranks.add(newScore);
            }
        }
        int rank = ranks.indexOf(newScore) + 1;
        System.out.println(rank > P ? -1 : rank);

    }
}
