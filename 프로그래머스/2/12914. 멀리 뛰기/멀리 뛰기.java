class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
        }
        return arr[n];
    }
}