import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int ans = 0;
        int pLength = p.length();
        long numP = Long.parseLong(p);

        for (int i = 0; i <= t.length() - pLength; i++) {
            if (Long.parseLong(t.substring(i, pLength + i)) <= numP) {
                ans++;
            }
        }
        return ans;
    }
}
