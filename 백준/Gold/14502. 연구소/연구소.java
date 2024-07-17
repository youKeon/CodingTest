import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 10;
    static int n, m;
    static int ans = Integer.MIN_VALUE;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) { // 빈칸이면 벽 세우기
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // step 2. 벽 세 개 세웠으면 감염 시키기
    static void bfs() {
        Queue<int[]> q = new LinkedList();
        int[][] tmpMap = new int[MAX][MAX];
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                tmpMap[i][j] = map[i][j];
                if (tmpMap[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = tmp[0] + dy[i];
                int nx = tmp[1] + dx[i];

                if (nx > 0 && nx <= m && ny > 0 && ny <= n && tmpMap[ny][nx] == 0) {
                    tmpMap[ny][nx] = 2;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        // step 3. 안전한 지역 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (tmpMap[i][j] == 0) cnt++;
            }
        }
        ans = Math.max(cnt, ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        map = new int[MAX][MAX];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // step 1. 벽 세우기
        dfs(0);

        System.out.print(ans);
    }
}