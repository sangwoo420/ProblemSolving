import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4386_별자리만들기 {
    private static class Point {
        double x, y;

        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        private double getDistance(Point p) {
            return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
        }

    }

    private static class Edge {
        Point a, b;
        double w;

        private Edge(Point a, Point b) {
            this.a = a;
            this.b = b;
            w = this.a.getDistance(this.b);
        }
    }

    private static Map<Point, Point> parents = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        StringTokenizer st;
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            double x = Double.parseDouble(st.nextToken()), y = Double.parseDouble(st.nextToken());
            points[i] = new Point(x, y);
            parents.put(points[i], points[i]);
        }
        PriorityQueue<Edge> edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.w, o2.w);
            }
        });
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                edges.offer(new Edge(points[i], points[j]));
            }
        }
        double answer = 0;
        int count = 0;
        while (!edges.isEmpty()) {
            Edge min = edges.poll();
            if(union(min.a, min.b)) {
                answer += min.w;
            }
        }
        System.out.printf("%.2f", answer);
    }

    private static Point find(Point p) {
        if (p.equals(parents.get(p))) return p;
        parents.put(p, find(parents.get(p)));
        return parents.get(p);
    }

    private static boolean union(Point a, Point b) {
        Point aRoot = find(a);
        Point bRoot = find(b);
        if (aRoot.equals(bRoot)) return false;
        parents.put(aRoot, bRoot);
        return true;
    }
}
