import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) System.out.print(arr[1]);
        else if (n == 2) System.out.print(arr[1] + arr[2]);
        else {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
            }
            System.out.print(dp[n]);
        }
    }
}