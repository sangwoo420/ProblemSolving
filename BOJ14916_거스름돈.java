import java.util.Scanner;

public class BOJ14916_거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        arr[1] = -1;
        for (int i = 2; i <= N; i++) {
            if (i >= 5) {
                int min = Math.min(arr[i - 5], arr[i - 2]), max = Math.max(arr[i - 5], arr[i - 2]);
                if (min < 0 && max < 0) {
                    arr[i] = -1;
                } else if (min < 0) {
                    arr[i] = max + 1;
                } else {
                    arr[i] = min + 1;
                }
            } else if (i >= 2) {
                arr[i] = arr[i - 2] != -1 ? arr[i - 2] + 1 : -1;
            }
        }
        System.out.println(arr[N]);
    }
}
