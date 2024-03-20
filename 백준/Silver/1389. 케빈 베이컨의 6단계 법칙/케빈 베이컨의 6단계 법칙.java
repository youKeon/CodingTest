import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 100 + 5;
    static int n, m, ans;
    static int[][] map;
    static int[] distance;

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        distance[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (distance[i] == -1 && map[cur][i] != 0) {
                    q.add(i);
                    distance[i] = distance[cur] + 1;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += distance[i];
        return sum;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[MAX][MAX];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
            map[x][y] = 1;
        }

        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            distance = new int[MAX];
            Arrays.fill(distance, -1);
            int count = bfs(i);
            if (min > count) {
                min = count;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
