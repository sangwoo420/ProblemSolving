import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1202_보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        List<int[]> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            jewels.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(jewels, Comparator.comparingInt(o -> o[0]));
        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(input.readLine()));
        }
        Collections.sort(bags);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]) * -1);
        long sum = 0;
        int index = 0;
        for(int bag : bags) {
            while(index < N && jewels.get(index)[0] <= bag) {
                pq.offer(jewels.get(index++));
            }
            if(!pq.isEmpty()) {
                sum += pq.poll()[1];
            }
        }
        System.out.println(sum);
    }
}
