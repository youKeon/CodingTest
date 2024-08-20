import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // y
        m = Integer.parseInt(st.nextToken()); // x

        map = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    count++;
                    int result = bfs(i, j);
                    max = Math.max(max, result);
                }
            }
        }
        System.out.println(count);
        System.out.print(max == Integer.MIN_VALUE ? 0 : max);
    }

    private static int bfs(int y, int x) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{y, x});
        isVisited[y][x] = true;
        int result = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            result++;

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] == 1 && !isVisited[ny][nx]) {
                    dq.offer(new int[]{ny, nx});
                    isVisited[ny][nx] = true;
                }
            }
        }
        return result;
    }
}