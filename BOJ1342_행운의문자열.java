import java.util.Scanner;

public class BOJ1342_행운의문자열 {
    private static int[] counts = new int[26];
    private static int N, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        N = s.length();
        answer = 0;
        for(int i = 0; i < 26; i++) {
            if(counts[i] != 0) {
                counts[i]--;
                makeWords(i, 1);
                counts[i]++;
            }
        }
        System.out.println(answer);
    }

    private static void makeWords(int startIndex, int depth) {
        if(depth == N) {
            answer++;
            return;
        }
        for(int i = 0; i < 26; i++) {
            if(i != startIndex && counts[i] != 0) {
                counts[i]--;
                makeWords(i, depth + 1);
                counts[i]++;
            }
        }
    }
}
