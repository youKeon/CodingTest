import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int p1 = 0;
        int p2 = people.length - 1;
        
        while (p1 <= p2) {
            if (people[p1] + people[p2] <= limit) {
                p1++;
                p2--;
                ans++;
            } else {
                p2--;
                ans++;
            }
        }
        return ans;
    }
}