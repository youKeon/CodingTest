class Solution {
    char[][] grid;
    boolean[][] isVisited;
    int ans = 0;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int numIslands(char[][] grid) {
        this.grid = grid;
        isVisited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    ans++;
                    bfs(i, j);
                }
            }
        }
        return ans;
    }

    private void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        isVisited[row][col] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny >= 0 && ny < grid.length && nx >= 0 && nx < grid[0].length && grid[ny][nx] == '1' && !isVisited[ny][nx]) {
                    q.add(new int[]{ny, nx});
                    isVisited[ny][nx] = true;
                }
            }
        }
    }
}