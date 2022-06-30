import java.util.Scanner;

public class BOJ1568_새 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long count = 0;
        int num = 1;
        while(N != 0) {
            if(N - num >= 0) {
                N -= num;
                num++;
                count++;
            } else {
                num = 1;
            }
        }
        System.out.println(count);
    }
}
