import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 20 + 3;
    static int R, C, ans;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Set<Character> set;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;
        map = new char[MAX][MAX];
        isVisited = new boolean[MAX][MAX];
        set = new HashSet<>();

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i + 1][j + 1] = tmp.charAt(j);
            }
        }

        set.add(map[1][1]);
        isVisited[1][1] = true;
        dfs(1, 1, 1);

        System.out.print(ans);
    }

    private static void dfs(int row, int col, int count) {
        ans = Math.max(ans, count);

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (!isVisited[nr][nc] && Character.isAlphabetic(map[nr][nc]) && !set.contains(map[nr][nc])) {
                set.add(map[nr][nc]);
                isVisited[nr][nc] = true;
                dfs(nr, nc, count + 1);
                set.remove(map[nr][nc]);
                isVisited[nr][nc] = false;
            }
        }
    }
}
