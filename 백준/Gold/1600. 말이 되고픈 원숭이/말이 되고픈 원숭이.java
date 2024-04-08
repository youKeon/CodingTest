import java.util.*;

class Main {
    static int[] dx = {-1, 1, 0, 0, -2, -2, 2, 2, -1, 1, -1, 1}; // 상하좌우 및 말의 이동 좌표
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1, -2, -2, 2, 2};
    static int[][] board;
    static int[][][] visited;
    static int K, W, H;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        K = scanner.nextInt();
        W = scanner.nextInt();
        H = scanner.nextInt();

        board = new int[H][W];
        visited = new int[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                board[i][j] = scanner.nextInt();
                for (int k = 0; k <= K; k++) {
                    visited[i][j][k] = INF; // 초기화
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int k = current[2];

            if (x == H - 1 && y == W - 1) {
                return visited[x][y][k];
            }

            for (int d = 0; d < 12; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nk = k + (d >= 4 ? 1 : 0); // 말의 이동인 경우 동작 횟수 증가

                if (nx < 0 || nx >= H || ny < 0 || ny >= W || board[nx][ny] == 1) {
                    continue;
                }

                if (d >= 4 && nk > K) { // 말의 이동일 때 K 초과하는지 확인
                    continue;
                }

                if (visited[nx][ny][nk] <= visited[x][y][k] + 1) {
                    continue; // 이미 방문한 경우 더 작은 동작 횟수로 방문했으므로 넘어감
                }

                visited[nx][ny][nk] = visited[x][y][k] + 1;
                queue.offer(new int[]{nx, ny, nk});
            }
        }

        return -1; // 도착점에 도달하지 못한 경우
    }
}
