class Solution {
    int k, ans;
    int[][] dungeons;
    boolean[] isVisited;

    public void dfs(int l, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i] && l >= dungeons[i][0]) {
                isVisited[i] = true;
                dfs(l - dungeons[i][1], cnt + 1);
                isVisited[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }

    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        this.isVisited = new boolean[dungeons.length];
        ans = 0;

        dfs(k, 0);

        return ans;
    }
}