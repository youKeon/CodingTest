import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.print(solution(n));
    }

    private static int solution(int n) {
        if (n == 1) return 0;
        if (n == 2 || n == 3) return 1;

        int[] dp = new int[n + 1];
        dp[2] = dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            if (i % 6 == 0) dp[i] = Math.min(dp[i - 1], Math.min(dp[i / 3], dp[i / 2])) + 1;
            else if (i % 2 == 0) dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            else if (i % 3 == 0) dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            else dp[i] = dp[i - 1] + 1;
        }
        return dp[n];
    }
}