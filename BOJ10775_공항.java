import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10775_공항 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(input.readLine());
        int P = Integer.parseInt(input.readLine());
        boolean[] gates = new boolean[G + 1];
        int[] parents = new int[G + 1];
        for (int i = 1; i <= G; i++) parents[i] = i;
        int count = 0;
        for(int i = 1; i <= P; i++) {
            int gate = Integer.parseInt(input.readLine());
            if(!gates[gate]) {
                gates[gate] = true;
                count++;
                parents[gate] = find(parents, gate - 1);
            } else {
                int next = find(parents, gate);
                if(next == 0) break;
                gates[next] = true;
                count++;
                parents[next] = find(parents, next - 1);
            }
        }
        System.out.println(count);
    }

    private static int find(int[] parents, int x) {
        if (parents[x] == x) return x;
        else return parents[x] = find(parents, parents[x]);
    }

}
