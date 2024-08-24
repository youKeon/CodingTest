import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, arr));
    }

    private static long solution(int n, int[][] arr) {
        if (n == 1) return arr[0][0];

        long result = Long.MIN_VALUE;
        long[][] dp = new long[n][n];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
            dp[i][i] = dp[i - 1][i - 1] + arr[i][i];
            result = Math.max(result, Math.max(dp[i][0], dp[i][i]));

            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
    }
}