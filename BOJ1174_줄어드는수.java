import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1174_줄어드는수 {
    private static List<Long> decreasingNumbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() - 1;
        decreasingNumbers = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            makeNumber(i);
        }
        Collections.sort(decreasingNumbers);
        if (N >= decreasingNumbers.size()) {
            System.out.println(-1);
        } else {
            System.out.println(decreasingNumbers.get(N));
        }
    }

    private static void makeNumber(long lastNum) {
        decreasingNumbers.add(lastNum);
        for (int i = 0; i <= 9; i++) {
            if (lastNum % 10 > i) {
                makeNumber(lastNum * 10 + i);
            }
        }
    }
}
