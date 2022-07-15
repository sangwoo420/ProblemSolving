import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17608_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(input.readLine()));
        }
        int count = 1, h = stack.pop();
        while(!stack.isEmpty()) {
            if(stack.peek() > h) {
                count++;
                h = stack.pop();
            } else {
                stack.pop();
            }
        }
        System.out.println(count);
    }
}
