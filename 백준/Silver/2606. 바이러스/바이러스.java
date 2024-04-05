import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 100 + 5;
    static int n, ans;
    static int[][] map;
    static boolean[] chk;
    
    static void dfs(int l) {
        chk[l] = true;
        
        for (int i = 1; i <= n; i++) {
            if (!chk[i] && map[l][i] == 1) {
                ans++;
                dfs(i);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());        
        
        map = new int[MAX][MAX];
        chk = new boolean[MAX];
        
        int m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        dfs(1);
        
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
}