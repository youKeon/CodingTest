class Solution {
    public int solution(String[][] board, int h, int w) {
        int ans = 0;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        String target = board[h][w];
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + h;
            int nx = dx[i] + w;
            
            if (ny >= 0 && ny < board.length && 
                nx >= 0 && nx < board[0].length && 
                board[ny][nx].equals(target)) {
                ans++;
            }
        }
        
        return ans;
    }
}