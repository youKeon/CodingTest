class Solution {
    int[][] map;
    boolean[] isVisited;
    int n, ans;
    
    public int solution(int n, int[][] computers) {
        this.map = computers;
        this.isVisited = new boolean[n];
        this.n = n;
        this.ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                ans++;
                dfs(i);
            }
        }
        return ans;
    }
    
    private void dfs(int l) {
        for (int i = 0; i < n; i++) {
            if (!isVisited[i] && map[l][i] == 1) {
                isVisited[i] = true;
                dfs(i);
            }
        }
    }
}

// 1 1 0
// 1 1 0
// 0 0 1