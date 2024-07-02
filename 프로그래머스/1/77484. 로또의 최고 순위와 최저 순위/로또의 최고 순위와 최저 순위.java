import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> lottoSet = new HashSet<>();
        Set<Integer> winSet = new HashSet<>();
        int count = 0;
        int min = 0;
        int max = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            lottoSet.add(lottos[i]);
            winSet.add(win_nums[i]);
            
            if (lottos[i] == 0) {
                count++;
            }
        }
        
        for (int i = 0; i < lottos.length; i++) {
            int lottoNumber = lottos[i];
            
            if (lottoNumber == 0 && count > 0) {
                count--;
                max++;
            } else if (winSet.contains(lottoNumber)) {
                max++;
                min++;
            } else {
                if (count > 0) {
                    count--;
                    max++;
                }
            }
        }
        int minRank = getRank(min);
        int maxRank = getRank(max);
        
        return new int[]{getRank(max), getRank(min)};
        
        
    }
    
    private int getRank(int score) {
        if (score == 6) return 1;
        if (score == 5) return 2;
        if (score == 4) return 3;
        if (score == 3) return 4;
        if (score == 2) return 5;
        return 6;
    }
}