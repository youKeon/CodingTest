import java.util.*;

class Solution {
    public int solution(int n) {
        int ans = 0;
        int total = 0;
        int p1 = 1;
        
        for (int p2 = 1; p2 <= n; p2++) {
            total += p2;
            
            while (total > n) {
                total -= p1;
                p1++;
            }
            
            if (total == n) {
                ans++;
            }
        }
        return ans;
    }
}