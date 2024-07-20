import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] dp = new int[30][30];

            dp[0][0] = 1;
            for (int j = 1; j < 30; j++) {
                dp[j][0] = 1;
                for (int k = 1; k <= j; k++) {
                    dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
                }
            }
            System.out.println(dp[M][N]);
        }
    }
}