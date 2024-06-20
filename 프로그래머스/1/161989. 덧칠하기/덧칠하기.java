import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int ans = 0;
        int index = 0;
        int point = 1;
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        while (point <= n && index < section.length) {
            if (point == section[index]) {
                point += m;
                ans++;
                
                while (index < section.length && section[index] < point) {
                    index++;
                }
            } else {
                point++;
            }
        }
        return ans;
    }
}