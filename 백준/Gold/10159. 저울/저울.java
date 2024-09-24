import java.io.*;
import java.util.*;

class Main {
    static int N, M, count;
    static int[][] map;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int large = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());
            map[large][small] = 2;
            map[small][large] = 1;
        }

        for (int i = 1; i <= N; i++) {
            count = 0;
            isVisited = new boolean[N + 1];
            isVisited[i] = true;

            dfs(i, 2);
            dfs(i, 1);

            System.out.println(N - (count + 1));
        }
    }

    static void dfs(int l, int dir) {
        for (int i = 1; i <= N; i++) {
            if (map[l][i] == dir && !isVisited[i]) {
                isVisited[i] = true;
                count++;
                dfs(i, dir);
            }
        }
    }
}