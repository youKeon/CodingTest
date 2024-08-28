import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  
        int K = Integer.parseInt(st.nextToken());  
        
        int[] W = new int[N + 1];  
        int[] V = new int[N + 1];  
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N + 1][K + 1];
        
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (W[i] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i]] + V[i]);
                }
            }
        }
        
        System.out.print(dp[N][K]);
    }
}