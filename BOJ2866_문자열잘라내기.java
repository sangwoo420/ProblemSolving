import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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
        Set<String> appearSet = new HashSet<>();
        for (int c = 0; c < C; c++) {
            StringBuilder s = new StringBuilder();
            for (int r = 0; r < R; r++) {
                s.append(strings[r][c]);
            }
            appearSet.add(s.toString());
        }
        for (int r = 1; r < R; r++) {
            appearSet = appearSet.stream().map((s -> s.substring(1))).collect(Collectors.toSet());
            if(appearSet.size() != C) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
