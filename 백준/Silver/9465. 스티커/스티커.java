import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer.append(solution(arr)).append("\n");
        }
        System.out.print(answer);
    }

    private static int solution(int[][] arr) {
        if (arr[0].length == 1) return Math.max(arr[0][0], arr[1][0]);

        int[][] dp = new int[2][arr[0].length];
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];

        dp[0][1] = arr[1][0] + arr[0][1];
        dp[1][1] = arr[0][0] + arr[1][1];

        for (int i = 2; i < arr[0].length; i++) {
            dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + arr[1][i];
        }

        return Math.max(dp[1][arr[0].length - 1], dp[0][arr[0].length - 1]);
    }
}
