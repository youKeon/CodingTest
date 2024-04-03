import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 30;
    static int n, cnt, range;
    static boolean[][] map;
    static int[] ans;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void dfs(int y, int x) {
        map[y][x] = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (map[ny][nx]) {
                range++;
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new boolean[MAX][MAX];
        ans = new int[MAX];
        ArrayList<Integer> arr = new ArrayList();

        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j+1] = (tmp.charAt(j) == '1') ? true : false;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j]) {
                    cnt++;
                    range = 1;
                    dfs(i, j);
                    arr.add(range);
                }
            }
        }

        Collections.sort(arr);

        bw.write(String.valueOf(cnt));
        bw.newLine();
        for (int i : arr) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}