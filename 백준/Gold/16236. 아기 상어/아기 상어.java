import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int y, x, size, eaten;
        public Shark(int y, int x, int size, int eaten) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.eaten = eaten;
        }
    }

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        Shark shark = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        while (true) {
            int[] result = bfs(shark);
            if (result[0] == -1) break;

            int dist = result[0];
            int y = result[1];
            int x = result[2];

            time += dist;
            shark.y = y;
            shark.x = x;
            shark.eaten++;

            if (shark.eaten == shark.size) {
                shark.size++;
                shark.eaten = 0;
            }

            map[y][x] = 0;
        }

        System.out.println(time);
    }

    private static int[] bfs(Shark shark) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];
        queue.add(new int[]{shark.y, shark.x, 0});
        visited[shark.y][shark.x] = true;

        List<int[]> fishes = new ArrayList<>();

        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int dist = current[2];

            if (dist > minDist) break;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                    visited[ny][nx] = true;

                    if (map[ny][nx] > 0 && map[ny][nx] < shark.size) {
                        minDist = dist;
                        fishes.add(new int[]{dist + 1, ny, nx});
                    }

                    // 상어가 지나갈 수 있는 경우
                    if (map[ny][nx] == 0 || map[ny][nx] == shark.size) {
                        queue.add(new int[]{ny, nx, dist + 1});
                    }
                }
            }
        }

        if (fishes.isEmpty()) return new int[]{-1, -1, -1};

        // 가장 가까운 물고기 중에서 위, 왼쪽 순으로 정렬
        fishes.sort((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[1], b[1]);
        });

        return fishes.get(0); // 최종 선택된 물고기 정보 반환
    }
}