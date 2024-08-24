import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.print(solution(n, arr));
    }

    private static int solution(int n, int[] arr) {
        if (n == 1) return arr[0];
        if (n == 2) return arr[0] + arr[1];

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(dp[1], Math.max(arr[0], arr[1]) + arr[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}