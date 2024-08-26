import java.io.*;
import java.util.*;

class Main {
    static int N, M, K;
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
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    int count = bfs(i, j);
                    answer = Math.max(answer, count);
                }
            }
        }
        System.out.print(answer);
    }

    private static int bfs(int y, int x) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(y, x));
        int result = 0;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            result++;

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny >= 1 && ny <= N && nx >= 1 && nx <= M && !isVisited[ny][nx] && map[ny][nx] != 0) {
                    isVisited[ny][nx] = true;
                    dq.offer(new Node(ny, nx));
                }
            }
        }
        return result;
    }
}