import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 1000 + 10;
    static int ans, n, m;
    static Queue<Node> q;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int bfs() {
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (map[ny][nx] == 0
                        && ny >= 1
                        && ny <= n
                        && nx >= 1
                        && nx <= m) {
                    map[ny][nx] = map[cur.y][cur.x] + 1;
                    q.add(new Node(ny, nx));
                }
            }
        }

        ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) return -1;
                ans = Math.max(ans, map[i][j]);
            }
        }

        if (ans == 1) return 0;
        else return ans - 1;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        q = new LinkedList<>();
        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        map = new int[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) q.add(new Node(i, j));
            }
        }
        System.out.print(bfs());
    }
}