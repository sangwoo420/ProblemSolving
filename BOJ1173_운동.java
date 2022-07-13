import java.util.Scanner;

public class BOJ1173_운동 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), m = sc.nextInt(), M = sc.nextInt(), T = sc.nextInt(), R = sc.nextInt();
        if(m + T > M) {
            System.out.println(-1);
            return;
        }
        int time = 0, beat = m;
        while(N > 0) {
            if(beat + T <= M) {
                N--;
                beat += T;
            } else {
                beat -= R;
                if(beat < m) {
                    beat = m;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
