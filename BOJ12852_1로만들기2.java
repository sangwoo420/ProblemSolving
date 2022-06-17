import java.util.Arrays;
import java.util.Scanner;

public class BOJ12852_1로만들기2 {
    private static int N;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        for (int i = 1; i <= N; i++) {
            if (i + 1 <= N && arr[i + 1] > arr[i] + 1) {
                arr[i + 1] = arr[i] + 1;
            }
            if (i * 2 <= N && arr[i * 2] > arr[i] + 1) {
                arr[i * 2] = arr[i] + 1;
            }
            if (i * 3 <= N && arr[i * 3] > arr[i] + 1) {
                arr[i * 3] = arr[i] + 1;
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(arr[N]).append("\n");
        int n = N;
        while (n != 1) {
            answer.append(n).append(" ");
            if (n - 1 >= 1 && arr[n - 1] == arr[n] - 1) {
                n -= 1;
            } else if (n % 2 == 0 && n / 2 >= 1 && arr[n / 2] == arr[n] - 1) {
                n /= 2;
            } else if (n % 3 == 0 && n / 3 >= 1 && arr[n / 3] == arr[n] - 1) {
                n /= 3;
            }
        }
        answer.append(1);
        System.out.println(answer);
    }
}