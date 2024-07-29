import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 510;
    static int m, n, ans;
    static int[][] map, dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int dfs(int y, int x) {
        if (y == m && x == n) return 1;
        if (dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (map[ny][nx] < map[y][x] && map[ny][nx] != 0) {
                dp[y][x] += dfs(ny, nx);
            }
        }
        return dp[y][x];
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[MAX][MAX];
        dp = new int[MAX][MAX];


        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j+1] = Integer.parseInt(st.nextToken());
                dp[i][j+1] = -1;
            }
        }

        bw.write(String.valueOf(dfs(1, 1)));
        bw.close();
        br.close();
    }
}