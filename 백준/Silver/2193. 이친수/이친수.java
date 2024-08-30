import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.print(solution(n));
    }

    private static long solution(int n) {
        if (n == 1 || n == 2)  return 1;
        long[] dp = new long[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}
/**
 * n = 3
 * 101
 * 100
 */

/**
 * dp[1] = 1 (1)
 * dp[2] = 1 (10)
 * dp[3] = 2 (100, 101)
 * dp[4] = 3 (1000, 1001, 1010)
 * dp[5] = 5 (10000, 10001, 10100, 10101, 10010)
 */