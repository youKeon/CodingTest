import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.print(solution(n));
    }

    private static int solution(int n) {
        if (n == 3) return 1;
        if (n == 4) return -1;
        if (n == 5) return 1;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (dp[i - 3] != -1 && dp[i - 3] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - 3]) + 1;
            if (dp[i - 5] != -1 && dp[i - 5] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - 5]) + 1;
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}