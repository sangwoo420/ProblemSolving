import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1100_하얀칸 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[8][];
        for(int i = 0; i < 8; i++) {
            board[i] = input.readLine().toCharArray();
        }
        int count = 0;
        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                if(r % 2 == 0) {
                    if(c % 2 == 0) {
                        if(board[r][c] == 'F') {
                            count++;
                        }
                    }
                } else {
                    if(c % 2 == 1) {
                        if(board[r][c] == 'F') {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
