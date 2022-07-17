import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ20665_독서실거리두기 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
        PriorityQueue<LocalTime[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1[0].compareTo(o2[0]) == 0) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        }));
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(input.readLine());
            LocalTime from = LocalTime.parse(st.nextToken(), DateTimeFormatter.ofPattern("HHmm"));
            LocalTime to = LocalTime.parse(st.nextToken(), DateTimeFormatter.ofPattern("HHmm"));
            pq.offer(new LocalTime[]{from, to});
        }
        int[] occupiedTimes = new int[N];
        Stack<LocalTime[]>[] stacks = new Stack[N];
        for (int i = 0; i < N; i++) {
            stacks[i] = new Stack<>();
        }
        while (!pq.isEmpty()) {
            boolean empty = true;
            for (int i = 0; i < N; i++) {
                if (!stacks[i].isEmpty()) {
                    empty = false;
                    break;
                }
            }
            if (empty) {
                stacks[0].push(pq.poll());
            } else {
                for (int i = 0; i < N; i++) {
                    if (!stacks[i].isEmpty() && stacks[i].peek()[1].compareTo(pq.peek()[0]) <= 0) {
                        occupiedTimes[i] += ChronoUnit.MINUTES.between(stacks[i].peek()[0], stacks[i].pop()[1]);
                    }
                }
                empty = true;
                for (int i = 0; i < N; i++) {
                    if (!stacks[i].isEmpty()) {
                        empty = false;
                        break;
                    }
                }
                if (empty) {
                    stacks[0].push(pq.poll());
                } else {
                    int[][] infos = new int[N][2];
                    for (int i = 0; i < N; i++) {
                        infos[i][0] = i;
                    }
                    for (int i = 0; i < N; i++) { // 빈좌석
                        for (int j = 0; j < N; j++) { // 차지된 좌석
                            if (i == j || !stacks[i].isEmpty() || stacks[j].isEmpty()) continue;
                            int dist = Math.abs(i - j);
                            if (infos[i][1] == 0) {
                                infos[i][1] = dist;
                            } else {
                                infos[i][1] = Math.min(dist, infos[i][1]);
                            }
                        }
                    }
                    Arrays.sort(infos, ((o1, o2) -> {
                        if (o1[1] == o2[1]) {
                            return Integer.compare(o1[0], o2[0]);
                        }
                        return Integer.compare(o1[1], o2[1]) * -1;
                    }));
                    stacks[infos[0][0]].push(pq.poll());
                }
            }
        }
        for (int i = 0; i < N; i++) {
            while (!stacks[i].isEmpty()) {
                occupiedTimes[i] += ChronoUnit.MINUTES.between(stacks[i].peek()[0], stacks[i].pop()[1]);
            }
        }
        System.out.println(720 - occupiedTimes[P - 1]);
    }
}
