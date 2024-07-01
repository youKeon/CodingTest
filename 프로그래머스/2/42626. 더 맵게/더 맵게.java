import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        int ans = 0;
        
        for (int i : scoville) {
            q.offer((long) i);
        }
        
        if (q.peek() >= K) {
            return 0;
        }
        
        while (true) {
            if (q.size() == 1) {
                return -1;
            }
            
            ans++;
            
            Long min1 = q.poll();
            Long min2 = q.poll();
            
            q.offer(min1 + (min2 * 2));
            
            if (q.peek() >= K) {
                break;
            }
        }
        return ans;
    }
}

// 제일 작은 거 + (두 번째로 작은 거 * 2)
