import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(n, arr));
    }

    private static int solution(int n, int[] arr) {
        if (n == 1) return arr[0];

        int[] dp = new int[n];
        dp[0] = arr[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}