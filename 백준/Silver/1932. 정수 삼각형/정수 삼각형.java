import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] map, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int len = st.countTokens();
            for (int j = 0; j < len; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solution());
    }

    private static int solution() {
        int ans = Integer.MIN_VALUE;
        dp[0][0] = map[0][0];
        if (n == 1) return dp[0][0];
        dp[1][0] = dp[0][0] + map[1][0];
        dp[1][1] = dp[0][0] + map[1][1];
        if (n == 2) return Math.max(dp[1][0], dp[1][1]);
        
        for (int i = 2; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
            dp[i][i] = dp[i - 1][i - 1] + map[i][i];
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + map[i][j];
            }
        }

        for (int[] i : dp) {
            for (int j : i) {
                ans = Math.max(ans, j);
            }
        }
        return ans;
    }
}