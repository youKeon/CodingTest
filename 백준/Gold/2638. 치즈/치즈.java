import java.util.*;

class Main {
    static int N, M;
    static int[][] grid;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int time = 0;
        while (hasCheeseLeft()) {
            simulateAir();
            meltCheese();
            time++;
        }

        System.out.println(time);
    }

    static void simulateAir() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : directions) {
                int nx = current[0] + dir[0];
                int ny = current[1] + dir[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && grid[nx][ny] <= 0) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    grid[nx][ny] = -1; 
                }
            }
        }
    }

    static void meltCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    int airContact = 0;
                    for (int[] dir : directions) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && grid[nx][ny] == -1) {
                            airContact++;
                        }
                    }
                    if (airContact >= 2) {
                        grid[i][j] = 0; 
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == -1) grid[i][j] = 0;
            }
        }
    }

    static boolean hasCheeseLeft() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) return true;
            }
        }
        return false;
    }
}