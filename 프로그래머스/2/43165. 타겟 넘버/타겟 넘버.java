class Solution {
    int ans;
    
    public int solution(int[] numbers, int target) {
        ans = 0;
        dfs(numbers, target, -1, 0);
        return ans;
    }
    
    private void dfs(int[] numbers, int target, int l, int total) {
        if (l == numbers.length - 1) {
            if (total == target) {
                ans++;
            }
            return;
        }
        
        dfs(numbers, target, l + 1, total + numbers[l + 1]);
        dfs(numbers, target, l + 1, total - numbers[l + 1]);
    }
}