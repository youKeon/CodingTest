import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = solution(n, map);
        System.out.print(ans);
    }

    private static int solution(int n, int[][] map) {
        int[][] dp = new int[n + 1][3];

        dp[1][0] = map[1][0];
        dp[1][1] = map[1][1];
        dp[1][2] = map[1][2];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][2];
        }

        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}