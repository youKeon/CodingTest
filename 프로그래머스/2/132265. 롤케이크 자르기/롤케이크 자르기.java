import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int ans = 0;
        
        for (int i : topping) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        
        for (int i = 0; i < topping.length; i++) {
            int cur = topping[i];
            
            map1.put(cur, map1.get(cur) - 1);
            if (map1.get(cur) == 0) {
                map1.remove(cur);
            }
            map2.put(cur, map2.getOrDefault(cur, 0) + 1);
            
            if (map1.size() == map2.size()) {
                ans++;
            }
        }
        
        return ans;
    }
}