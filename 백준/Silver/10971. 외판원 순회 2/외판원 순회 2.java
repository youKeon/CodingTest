import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 10 + 5;
    static int n, ans;
    static int[][] map;
    static boolean[] isVisited;

    static void dfs(int l, int depth, int count, int start) {
        if (depth == n) {
            if (map[l][start] != 0) ans = Math.min(ans, count + map[l][start]);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isVisited[i] && map[l][i] != 0) {
                isVisited[i] = true;
                dfs(i, depth + 1, count + map[l][i], start);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        map = new int[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            isVisited = new boolean[MAX];
            isVisited[i] = true;
            dfs(i, 1, 0,  i);
        }
        System.out.print(ans);
    }
}
