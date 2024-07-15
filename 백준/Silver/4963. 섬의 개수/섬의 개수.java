import java.io.*;
import java.util.*;

class Main {
    static int w, h;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            String chk = br.readLine();
            if (chk.equals("0 0")) {
                break;
            }

            int ans = 0;
            st = new StringTokenizer(chk);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[h + 5][w + 5];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i + 1][j + 1] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i + 1][j + 1] == 1) {
                        ans++;
                        bfs(i + 1, j + 1);
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static void bfs(int y, int x) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{y, x});
        map[y][x] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int i = 0; i < 8; i++) {
                int ny = dy[i] + cur[0];
                int nx = dx[i] + cur[1];

                if (map[ny][nx] == 1) {
                    dq.offer(new int[]{ny, nx});
                    map[ny][nx] = 0;
                }
            }
        }
    }
}