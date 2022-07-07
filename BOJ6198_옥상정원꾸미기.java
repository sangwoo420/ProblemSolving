import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ6198_옥상정원꾸미기 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        Stack<Integer> stk = new Stack<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(input.readLine());
            if (stk.isEmpty() || stk.peek() > n) {
                stk.push(n);
            } else {
                while (!stk.isEmpty() && stk.peek() <= n) {
                    stk.pop();
                    answer += stk.size();
                }
                stk.push(n);
            }
        }
        while(!stk.isEmpty()) {
            stk.pop();
            answer += stk.size();
        }
        System.out.println(answer);
    }
}
