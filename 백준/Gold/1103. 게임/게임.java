import java.util.*;

class Main {
    static int N, M;
    static char[][] board;
    static int[][] dp;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
    static final int CYCLE = -2;
    static final int UNVISITED = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = sc.next().toCharArray();
            Arrays.fill(dp[i], UNVISITED);
        }

        int result = dfs(0, 0);
        System.out.println(result == CYCLE ? -1 : result);
    }

    static int dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M || board[x][y] == 'H') {
            return 0;
        }

        if (dp[x][y] != UNVISITED) {
            return dp[x][y];
        }

        dp[x][y] = CYCLE; // 사이클 감지를 위해 임시로 설정
        int maxMove = 0;

        for (int[] dir : direction) {
            int move = board[x][y] - '0';
            int nx = x + dir[0] * move;
            int ny = y + dir[1] * move;
            int result = dfs(nx, ny);
            if (result == CYCLE) {
                return dp[x][y] = CYCLE;
            }
            maxMove = Math.max(maxMove, result + 1);
        }

        return dp[x][y] = maxMove;
    }
}