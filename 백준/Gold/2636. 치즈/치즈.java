import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time = 0;
    static int lastCheese = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int currentCheese = countCheese();
            if (currentCheese == 0) break;
            lastCheese = currentCheese;
            meltCheese();
            time++;
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }

    static void meltCheese() {
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

                if (cheese[nx][ny] == 1) {
                    cheese[nx][ny] = 0;
                } else {
                    queue.offer(new int[]{nx, ny});
                }
                visited[nx][ny] = true;
            }
        }
    }

    static int countCheese() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheese[i][j] == 1) count++;
            }
        }
        return count;
    }
}