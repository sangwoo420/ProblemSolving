import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2174_로봇시뮬레이션 {
    private static class Robot {
        int x, y, direction;

        private Robot(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    private static final int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // E N W S

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
        int[][] map = new int[X + 1][Y + 1];
        st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Robot[] robots = new Robot[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            map[x][y] = i;
            robots[i] = new Robot(x, y, getDirection(d));
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            char command = st.nextToken().charAt(0);
            int commandCount = Integer.parseInt(st.nextToken());
            switch (command) {
                case 'F':
                    int nx = robots[n].x, ny = robots[n].y;
                    for (int j = 0; j < commandCount; j++) {
                        nx += deltas[robots[n].direction][0];
                        ny += deltas[robots[n].direction][1];
                        if (nx < 1 || nx > X || ny < 1 || ny > Y) {
                            System.out.printf("Robot %d crashes into the wall", n);
                            return;
                        }
                        if (map[nx][ny] != 0) {
                            System.out.printf("Robot %d crashes into robot %d", n, map[nx][ny]);
                            return;
                        }
                    }
                    map[nx][ny] = n;
                    map[robots[n].x][robots[n].y] = 0;
                    robots[n].x = nx;
                    robots[n].y = ny;
                    break;
                case 'L':
                    int nd = (robots[n].direction + commandCount) % 4;
                    robots[n].direction = nd;
                    break;
                case 'R':
                    nd = ((robots[n].direction - commandCount) % 4 + 4) % 4;
                    robots[n].direction = nd;
                    break;
            }
        }
        System.out.printf("OK");
    }

    private static int getDirection(char d) {
        switch (d) {
            case 'E':
                return 0;
            case 'N':
                return 1;
            case 'W':
                return 2;
            default:
                return 3;
        }
    }
}

