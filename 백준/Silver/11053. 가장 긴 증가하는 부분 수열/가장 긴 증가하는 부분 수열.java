import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        System.out.print(solution(br, n, arr, dp));
    }

    private static int solution(BufferedReader br, int n, int[] arr, int[] dp) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        if (n == 1) return dp[0];

        dp[1] = arr[1] > arr[0] ? 2 : 1;
        if (n == 2) return dp[1];

        int ans = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}