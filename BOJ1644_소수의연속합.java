import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ1644_소수의연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!isNotPrime[i]) primeList.add(i);
        }
        int left = 0, right = 0, sum = 0, count = 0;
        while(sum < N && right < primeList.size()) {
            sum += primeList.get(right++);
            if(sum == N) {
                count++;
                sum -= primeList.get(left++);
            } else if (sum > N) {
                while(sum > N && left < primeList.size()) {
                    sum -= primeList.get(left++);
                }
                if(sum == N) {
                    count++;
                    sum -= primeList.get(left++);
                }
            }
        }
        System.out.println(count);
    }
}
