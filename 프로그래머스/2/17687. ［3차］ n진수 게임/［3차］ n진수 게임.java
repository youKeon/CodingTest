class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (int i = sb.length(); i <= t * m; i++) {
            sb.append(Integer.toString(i, n));
        }

        for (int i = p - 1; i < t * m; i += m) {
            ans.append(sb.charAt(i));
        }
        return ans.toString().toUpperCase();
    }
}