import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ2866_문자열잘라내기 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        char[][] strings = new char[R][];
        for (int r = 0; r < R; r++) {
            strings[r] = input.readLine().toCharArray();
        }
        int count = 0;
        Map<String, Boolean> appearMap = new HashMap<>();
        for (int c = 0; c < C; c++) {
            StringBuilder s = new StringBuilder();
            for (int r = 0; r < R; r++) {
                s.append(strings[r][c]);
            }
            appearMap.put(s.toString(), true);
        }
        for (int r = 1; r < R; r++) {
            Map<String, Boolean> tmpMap = new HashMap<>();
            appearMap.forEach(((s, aBoolean) -> {
                tmpMap.put(s.substring(1),aBoolean);
            }));
            if(tmpMap.size() != C) {
                break;
            }
            count++;
            appearMap = tmpMap;
        }
        System.out.println(count);
    }
}
