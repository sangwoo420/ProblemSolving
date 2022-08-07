import java.util.Scanner;

public class BOJ1550_16진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hex = sc.next();
        System.out.println(Integer.parseInt(hex.toLowerCase(), 16));
    }
}
