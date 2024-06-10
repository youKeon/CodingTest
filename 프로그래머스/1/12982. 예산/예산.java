import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int ans = 0;
        Arrays.sort(d);
        
        for (int i : d) {
            if (budget - i < 0) {
                return ans;
            }
            
            budget -= i;
            ans++;
        }
        return d.length;
    }
}