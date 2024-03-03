import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        int total = 0;

        for (int i : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    ans++;
                    total += i;
                    q.add(i);
                    break;
                }

                if (q.size() == bridge_length) total -= q.poll();
                else {
                    if (total + i <= weight) {
                        ans++;
                        total += i;
                        q.add(i);
                        break;
                    } else {
                        ans++;
                        q.add(0);
                    }
                }
            }
        }
        return ans + bridge_length;
    }
}