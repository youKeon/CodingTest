class Solution {
    int n, ans;
    int[][] computers;
    int[][] map;
    boolean[] isVisited;

    public void dfs(int l) {
        isVisited[l] = true;
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i] && map[l][i] == 1) {
                dfs(i);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.n = n;

        map = new int[n+3][n+3];
        isVisited = new boolean[n+3];

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i+1][j+1] = computers[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!isVisited[i] && map[i][j] == 1) {
                    ans++;
                    dfs(i);
                }
            }
        }
        return ans;
    }
}