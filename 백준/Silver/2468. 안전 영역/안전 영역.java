import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 110;
    static int n, ans, limit, count;
    static boolean[][] chk;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    static void dfs(int y, int x) {
        chk[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!chk[ny][nx] && map[ny][nx] > limit) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            count = 0;
            chk = new boolean[MAX][MAX];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (!chk[i][j] && map[i][j] > limit) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            if (count == 0) break;
            else {
                ans = Math.max(ans, count);
            }
            limit++;
        }

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
}