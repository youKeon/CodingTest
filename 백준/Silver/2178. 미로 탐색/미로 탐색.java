import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 110;
    static int n, m, ans;
    static int map[][];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Cell {
        int y;
        int x;

        public Cell(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs() {
        Queue<Cell> q = new LinkedList();
        q.add(new Cell(1, 1));

        while(!q.isEmpty()) {
            Cell cell = q.poll();
            if (cell.y == m && cell.x == n) return;
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];

                if (map[ny][nx] == 1) {
                    q.add(new Cell(ny, nx));
                    map[ny][nx] = map[cell.y][cell.x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        map = new int[MAX][MAX];

        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = (tmp.charAt(j-1) == '1') ? 1 : 0;
            }
        }

        bfs();

        bw.write(String.valueOf(map[n][m]));
        bw.close();
        br.close();
    }
}