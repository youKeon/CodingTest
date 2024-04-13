import java.util.*;
import java.io.*;

class Main {
    static int n, m, x, y, k, count, size;
    static boolean[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void dfs(int y, int x) {
        map[y][x] = true;
        size++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m)
                if (!map[ny][nx]) {
                    dfs(ny, nx);
                }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 세로
        n = Integer.parseInt(st.nextToken()); // 가로
        k = Integer.parseInt(st.nextToken());
        map = new boolean[m][n];
        ArrayList<Integer> ans = new ArrayList();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int z = x1; z < x2; z++) {
                    map[j][z] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!map[i][j]) {
                    count++;
                    dfs(i, j);
                    ans.add(size);
                    size = 0;
                }
            }
        }
        Collections.sort(ans);
        bw.write(String.valueOf(count));
        bw.newLine();
        for (int i = 0; i < ans.size(); i++) bw.write(String.valueOf(ans.get(i)) + " ");
        bw.close();
        br.close();
    }
}