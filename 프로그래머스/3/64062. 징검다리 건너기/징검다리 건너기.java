class Solution {
    public int solution(int[] stones, int k) {
        int left = 1, right = 1 << 30, max = 0;
        while(left <= right){
            int mid = (left / 2) + (right / 2), cnt = 0;
            for(int i : stones) {
                cnt = (i - mid) < 0 ? cnt + 1 : 0;
                if(cnt == k) break;
            }
            if(cnt < k) {
                left = mid + 1;
                max = Math.max(max, mid);
            }
            else right = mid - 1;
        }
        return max;
    }
}
