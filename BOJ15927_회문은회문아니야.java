import java.util.Scanner;

public class BOJ15927_회문은회문아니야 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int start = 0, end = s.length() - 1;
        int answer = -1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                answer = Math.max(answer, s.length());
            }
            start++;
            end--;
        }
        start = 0; end = s.length() - 2;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                answer = Math.max(answer, s.length() - 1);
            }
            start++;
            end--;
        }
        System.out.println(answer);
    }
}
