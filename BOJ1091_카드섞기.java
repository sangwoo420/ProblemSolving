import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1091_카드섞기 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] targets = new int[N];
        for (int i = 0; i < N; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = i;
        }
        st = new StringTokenizer(input.readLine());
        int[] patterns = new int[N];
        for (int i = 0; i < N; i++) {
            patterns[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        while (!check(cards,targets)) {
            cards = shuffle(cards, patterns);
            count++;
            if(isLooped(cards)) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }

    private static int[] shuffle(int[] cards, int[] patterns) {
        int[] tmp = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            tmp[patterns[i]] = cards[i];
        }
        return tmp;
    }

    private static boolean check(int[] cards, int[] targets) {
        for (int i = 0; i < cards.length; i++) {
            if (targets[cards[i]] != i % 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLooped(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != i) {
                return false;
            }
        }
        return true;
    }
}
