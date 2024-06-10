import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            String tmp = s.substring(1, s.length());
            int ans = Integer.parseInt(tmp); 
            if (s.charAt(0) == '+') {
                return ans; 
            }
            
            ans *= -1;
            return ans;
        } 
        return Integer.parseInt(s);
    }
}