import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 1000 + 3;
    static int[][] map;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            map = new int[MAX][MAX];
            isVisited = new boolean[MAX];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                map[i][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int i = 1; i <= n; i++) {
                if (!isVisited[i]) {
                    ans++;
                    dfs(i, n);
                }
            }
            System.out.println(ans);
        }
    }

    private static void dfs(int l, int n) {
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i] && map[l][i] == 1) {
                isVisited[i] = true;
                dfs(i, n);
            }
        }
    }
}
