import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int p1 = 0;
        int p2 = people.length - 1;
        int total = 0;
        
        while (p1 <= p2) {
            total = people[p1] + people[p2];
            
            if (total > limit) {
                ans++;
                p2--;
            } else if (total <= limit) {
                ans++;
                p2--;
                p1++;
            }
        }
        return ans;
    }
}