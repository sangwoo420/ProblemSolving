import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ2023_신기한소수 {
    private static PriorityQueue<Integer> pq;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pq = new PriorityQueue<>();
        long start = System.currentTimeMillis();
        for(int i = 0; i <= 9; i++) {
            makePrime(i, N - 1);
        }
        StringBuilder answer = new StringBuilder();
        while(!pq.isEmpty()) {
            answer.append(pq.poll()).append("\n");
        }
        System.out.println(answer);
    }
    private static void makePrime(int n, int depth) {
        if(!isPrime(n)) {
            return;
        }
        if (depth == 0) {
            pq.offer(n);
            return;
        }
        for(int i = 0; i <= 9; i++) {
            makePrime(10 * n + i, depth - 1);
        }
    }

    private static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
