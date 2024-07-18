import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y, x, dist, isBroke;

        public Node(int y, int x, int dist, int isBroke) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.isBroke = isBroke;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1]; 
        isVisited = new boolean[N + 1][M + 1][2];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        int ans = bfs();
        System.out.print(ans);
    }

    private static int bfs() {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(0, 0, 1, 0));
        isVisited[0][0][0] = true;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();

            if (cur.y == N - 1 && cur.x == M - 1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) { 
                    if (map[ny][nx] == 0 && !isVisited[ny][nx][cur.isBroke]) {
                        dq.offer(new Node(ny, nx, cur.dist + 1, cur.isBroke));
                        isVisited[ny][nx][cur.isBroke] = true;
                    } else if (map[ny][nx] == 1 && cur.isBroke == 0 && !isVisited[ny][nx][1]) {
                        dq.offer(new Node(ny, nx, cur.dist + 1, 1));
                        isVisited[ny][nx][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}