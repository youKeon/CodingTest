class Solution {
    public long solution(long n) {
        for (long i = 1; i <= n; i++) {
            if (i * i == n) {
                return (i + 1) * (i + 1) % Long.MAX_VALUE;
            }
        }
        return -1;
    }
}