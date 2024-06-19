import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int ans = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrimeNumber(nums[i] + nums[j] + nums[k])) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    private boolean isPrimeNumber(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        
        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}