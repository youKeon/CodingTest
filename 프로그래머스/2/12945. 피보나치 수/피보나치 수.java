import java.util.*;

class Solution {
    public int solution(int n) {
        
        if (n == 2) return 1;
        
        int[] ans = new int[n+1];
        ans[1] = ans[2] = 1;
        
        for (int i = 3; i <= n; i++) ans[i] = (ans[i-2] + ans[i-1]) % 1234567;
        
        return ans[n];
        
    }
}