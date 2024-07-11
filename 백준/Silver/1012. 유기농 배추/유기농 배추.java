
import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 50 + 5;
    static int M, N, K;
    static int[][] map;
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

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            map = new int[MAX][MAX];
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // x
            N = Integer.parseInt(st.nextToken()); // y
            K = Integer.parseInt(st.nextToken()); // 배추

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }
            int result = bfs();
            System.out.println(result);
        }
    }

    private static int bfs() {
        Deque<Node> dq = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    dq.offer(new Node(i, j));
                    map[i][j] = 0;
                    result++;

                    while (!dq.isEmpty()) {
                        Node cur = dq.poll();

                        for (int k = 0; k < 4; k++) {
                            int ny = cur.y + dy[k];
                            int nx = cur.x + dx[k];

                            if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 1) {
                                dq.offer(new Node(ny, nx));
                                map[ny][nx] = 0;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}