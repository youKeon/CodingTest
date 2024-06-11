import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            int count = food[i];
            
            for (int j = 0; j < count / 2; j++) {
                sb1.append(i);
                sb2.insert(0, i);
            }
        }
        return sb1.append(0).append(sb2).toString();
    }
}