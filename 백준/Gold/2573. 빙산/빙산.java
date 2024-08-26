import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
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
        while (true) {
            int size = getSize();
            if (size > 1) {
                System.out.print(ans);
                break;
            }

            if (size == 0) {
                System.out.print(0);
                break;
            }

            ans++;
            melt();
        }
    }

    private static int getSize() {
        int size = 0;
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !isVisited[i][j]) {
                    size++;
                    bfs(i, j);
                }
            }
        }
        return size;
    }

    private static void bfs(int y, int x) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(y, x));
        isVisited[y][x] = true;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && !isVisited[ny][nx] && map[ny][nx] != 0) {
                    dq.offer(new Node(ny, nx));
                    isVisited[ny][nx] = true;
                }
            }
        }
    }

    private static void melt() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] != 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (ny >= 0 && ny < N && nx >= 0 && nx < M && copyMap[ny][nx] == 0) {
                            count++;
                        }
                    }
                    map[i][j] = Math.max(map[i][j] - count, 0);
                }
            }
        }
    }
}