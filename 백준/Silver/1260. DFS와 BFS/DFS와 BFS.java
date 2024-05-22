import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 1000 + 10;
    static int n, m, v, idx;
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int[] ans;
    static boolean[] chk;


    static void dfs(int l) {
        chk[l] = true;
        sb.append(l).append(" ");
        for (int i = 1; i <= n; i++) {
            if (!chk[i] && map[l][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList();
        q.add(v);
        chk[v] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();

            sb.append(tmp).append(" ");
            for (int i = 1; i <= n; i++) {
                if (!chk[i] && map[tmp][i] == 1) {
                    chk[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());


        map = new int[MAX][MAX];


        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        ans = new int[n + 1];
        chk = new boolean[MAX];
        dfs(v);
        sb.append("\n");

        ans = new int[n + 1];
        chk = new boolean[MAX];
        bfs();

        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}