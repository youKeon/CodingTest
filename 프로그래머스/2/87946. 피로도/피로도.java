class Solution {
    int k;
    int ans;
    int[][] dungeons;
    boolean[] isVisited;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.k = k;
        this.ans = Integer.MIN_VALUE;
        this.isVisited = new boolean[dungeons.length];
        
        dfs(k, 0);
        
        return ans;
    }
    
    private void dfs(int remain, int depth) {
        if (depth == dungeons.length) {
            ans = depth;
            return;
        }
        
        ans = Math.max(ans, depth);

        if (remain == 0) {
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i] && remain >= dungeons[i][0]) {
                isVisited[i] = true;
                dfs(remain - dungeons[i][1], depth + 1);
                isVisited[i] = false;
            }
        }
    }
}

// [80, 20]
// 최소 80이 필요하고 20이 소모됨