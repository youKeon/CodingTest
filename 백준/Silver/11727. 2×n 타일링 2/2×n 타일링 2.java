import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        System.out.print(solution(n));
    }

    private static int solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 3;
        if (n == 3) return 5;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
        }
        return dp[n];
    }
}