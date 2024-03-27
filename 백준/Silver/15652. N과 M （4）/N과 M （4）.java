import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] ans, arr;
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int depth, int at) {
        if (depth == m) {
            for (int i : ans) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        
        for (int i = at; i <= n; i++) {
            ans[depth] = i;
            dfs(depth + 1, i);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        ans = new int[m];
        
        dfs(0, 1);
        
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}