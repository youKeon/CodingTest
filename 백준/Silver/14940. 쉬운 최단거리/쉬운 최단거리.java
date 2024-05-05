import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static final int MAX = 1000 + 10;
    static int[][] map;
    static int[] start;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        map[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (map[ny][nx] == -1) {
                    q.add(new int[]{ny, nx});
                    map[ny][nx] = map[y][x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2)  start = new int[]{i, j};
                else {
                    map[i][j] = num == 1 ? -1 : 0;
                }
            }
        }

        bfs();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}