import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int ans = 0;
        
        for (int i = 0; i <= score.length - m; i += m) {
            ans += (score[score.length - i - m] * m);
        }
        
        return ans;
    }
}

// min * 개수