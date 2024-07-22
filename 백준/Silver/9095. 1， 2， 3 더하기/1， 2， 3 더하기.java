import java.io.*;
import java.util.*;

class Main {
    static int[] arr = {1, 2, 3};
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) System.out.println(0);
            else if (n == 1) System.out.println(1);
            else if (n == 2) System.out.println(2);
            else if (n == 3) System.out.println(4);
            else {
                int[] dp = new int[n + 1];
                dp[0] = 0;
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;

                for (int i = 4; i <= n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
                System.out.println(dp[n]);
            }
        }
    }
}