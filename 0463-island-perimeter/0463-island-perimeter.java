class Solution {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    int[][] grid;
    boolean[][] isVisited;
    int ans;

    public int islandPerimeter(int[][] grid) {
        this.ans = 0;
        this.isVisited = new boolean[grid.length][grid[0].length];
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    return ans;
                }
            }
        }
        // If no island is found
        return 0;
    }

    private void dfs(int row, int col) {
        isVisited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int ny = row + dy[i];
            int nx = col + dx[i];

            if (isOutOfRange(ny, nx) || grid[ny][nx] == 0) {
                ans++;
            } else if (!isVisited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

    private boolean isOutOfRange(int ny, int nx) {
        return ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[0].length;
    }

}
