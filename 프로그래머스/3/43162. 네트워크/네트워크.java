class Solution {
    boolean[] isVisited;
    public int solution(int n, int[][] computers) {
        int ans = 0;
        this.isVisited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                ans++;
                
                dfs(n, computers, i);
            }
        }
        return ans;
    }
    
    private void dfs(int n, int[][] computers, int l) {
        for (int i = 0; i < n; i++) {
            if (!isVisited[i] && computers[l][i] == 1) {
                isVisited[i] = true;
                dfs(n, computers, i);
            }
        }
    }
}