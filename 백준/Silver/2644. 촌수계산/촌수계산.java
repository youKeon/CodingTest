import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 100 + 3;
    static int n, m, x, y;
    static int[][] map;
    static int[] isVisited;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new int[MAX][MAX];
        isVisited = new int[MAX];
        Arrays.fill(isVisited, -1);
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        int ans = bfs(x, y);

        System.out.print(ans);
    }

    private static int bfs(int from, int to) {
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        isVisited[from] = 0;

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            if (cur == to) return isVisited[cur];

            for (int i = 1; i <= n; i++) {
                if (isVisited[i] == -1 && map[cur][i] != 0) {
                    q.add(i);
                    isVisited[i] = isVisited[cur] + 1;
                }
            }
        }
        return -1;
    }
}
