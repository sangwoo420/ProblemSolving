import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1360_되돌리기 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        Stack<String> commandStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            commandStack.push(input.readLine());
        }
        StringBuilder answer = new StringBuilder();
        while (!commandStack.isEmpty()) {
            String current = commandStack.pop();
            StringTokenizer st = new StringTokenizer(current);
            String command = st.nextToken();
            if ("type".equals(command)) {
                answer.append(st.nextToken());
                st.nextToken();
            } else {
                if(commandStack.isEmpty()) break;
                int limit = (Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken())) * -1;
                String next = commandStack.peek();
                st = new StringTokenizer(next);
                st.nextToken();
                st.nextToken();
                int nextTime = Integer.parseInt(st.nextToken());
                while(nextTime >= limit) {
                    commandStack.pop();
                    if(commandStack.isEmpty()) break;
                    next = commandStack.peek();
                    st = new StringTokenizer(next);
                    st.nextToken();
                    st.nextToken();
                    nextTime = Integer.parseInt(st.nextToken());
                }
            }
        }
        System.out.println(answer.reverse());
    }
}
