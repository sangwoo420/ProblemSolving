import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1092_배 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        List<Integer> cranes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(cranes, Comparator.reverseOrder());
        int M = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(boxes,Comparator.reverseOrder());
        if (cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }
        int count = 0;
        while (!boxes.isEmpty()) {
            for (int i = 0, j = 0; i < N; i++) {
                while(j < boxes.size() && cranes.get(i) < boxes.get(j)) {
                    j++;
                }
                if(j == boxes.size()) {
                    break;
                }
                boxes.remove(j);
                if(boxes.isEmpty()) {
                    break;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
