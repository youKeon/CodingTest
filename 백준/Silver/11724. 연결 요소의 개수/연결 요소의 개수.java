import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 1000 + 10;
    static int n, m, ans;
    static boolean[] chk;
    static boolean[][] arr;

    static void dfs(int l) {
        chk[l] = true;

        for (int i = 1; i <= n; i++) {
            if (!chk[i] && arr[l][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new boolean[MAX][MAX];
        chk = new boolean[MAX];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!chk[i])
                ans++;
                dfs(i);
        }
        System.out.println(ans);
    }
}
