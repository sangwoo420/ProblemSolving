import java.util.Scanner;

public class BOJ11726_2xn타일링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        arr[1] = 1;
        if (N >= 2) {
            arr[2] = 2;
        }
        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i - 1] % 10007 + arr[i - 2] % 10007) % 10007;
        }
        System.out.println(arr[N]);
    }
}
