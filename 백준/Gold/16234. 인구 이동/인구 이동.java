import java.io.*;
import java.util.*;

class Main {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            boolean moved = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }
            days++;
        }

        System.out.println(days);
    }

    private static boolean bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        queue.offer(new int[] {y, x});
        union.add(new int[] {y, x});
        visited[y][x] = true;

        int sum = A[y][x];
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                    int diff = Math.abs(A[curY][curX] - A[ny][nx]);
                    if (diff >= L && diff <= R) {
                        queue.offer(new int[] {ny, nx});
                        union.add(new int[] {ny, nx});
                        visited[ny][nx] = true;
                        sum += A[ny][nx];
                        count++;
                    }
                }
            }
        }

        if (count > 1) {
            int newPop = sum / count;
            for (int[] pos : union) {
                A[pos[0]][pos[1]] = newPop;
            }
            return true;
        }

        return false;
    }
}