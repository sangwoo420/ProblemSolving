import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1005_ACMCraft {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
            int[] requireTime = new int[N + 1];
            st = new StringTokenizer(input.readLine());
            for (int i = 1; i <= N; i++) {
                requireTime[i] = Integer.parseInt(st.nextToken());
            }

            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(input.readLine());
                int parent = Integer.parseInt(st.nextToken()), child = Integer.parseInt(st.nextToken());
                List<Integer> parents = map.getOrDefault(child, new ArrayList<>());
                parents.add(parent);
                map.put(child, parents);
            }
            int W = Integer.parseInt(input.readLine());
            int[] builtTime = new int[N + 1];
            Arrays.fill(builtTime, -1);
            answer.append(getDelay(W, map, requireTime, builtTime)).append("\n");
        }
        System.out.println(answer);
    }
    private static int getDelay(int w, Map<Integer, List<Integer>> map, int[] requireTime, int[] builtTime) {
        if(map.get(w) == null) {
            return requireTime[w];
        }
        if(builtTime[w] != -1) return builtTime[w];
        int longest = Integer.MIN_VALUE;
        for(int parent : map.get(w)) {
            int tmp = getDelay(parent, map, requireTime, builtTime);
            if(longest < tmp) longest = tmp;
        }
        return builtTime[w] = requireTime[w] + longest;
    }
}