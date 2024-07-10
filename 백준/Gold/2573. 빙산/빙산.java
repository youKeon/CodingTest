import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int count = 0;

        while ((count = getCount()) < 2) {
            if (count == 0) {
                ans = 0;
                break;
            }

            Melt();
            ans++;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getCount() {
        boolean[][] isVisited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !isVisited[i][j]) {
                    dfs(i, j, isVisited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int x, int y, boolean[][] isVisited) {
        isVisited[x][y] = true;

        int dx, dy;
        for (int i = 0; i < 4; i++) {
            dx = x + Main.dx[i];
            dy = y + Main.dy[i];

            if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                continue;
            }

            if (map[dx][dy] != 0 && !isVisited[dx][dy]) {
                dfs(dx, dy, isVisited);
            }
        }
    }

    // 빙하를 녹이는 함수.
    public static void Melt() {
        Deque<Node> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    dq.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int dx, dy;
        while (!dq.isEmpty()) {
            Node cur = dq.poll();

            int count = 0; 

            for (int i = 0; i < 4; i++) {
                dx = cur.x + Main.dx[i];
                dy = cur.y + Main.dy[i];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }

                if (!visited[dx][dy] && map[dx][dy] == 0) {
                    count++;
                }
            }

            if (map[cur.x][cur.y] - count < 0) {
                map[cur.x][cur.y] = 0;
            } else {
                map[cur.x][cur.y] -= count;
            }
        }
    }
}