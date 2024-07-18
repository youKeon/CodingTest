import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y, dist, wallBroken;

        Point(int x, int y, int dist, int wallBroken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wallBroken = wallBroken;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) {
                        if (!visited[nx][ny][current.wallBroken]) {
                            queue.offer(new Point(nx, ny, current.dist + 1, current.wallBroken));
                            visited[nx][ny][current.wallBroken] = true;
                        }
                    } else if (map[nx][ny] == 1 && current.wallBroken == 0) {
                        if (!visited[nx][ny][1]) {
                            queue.offer(new Point(nx, ny, current.dist + 1, 1));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
}