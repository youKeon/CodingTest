class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i - 1] == ' ') {
                if (Character.isAlphabetic(arr[i])) {
                    arr[i] -= 32;
                }
            }
        }
        return String.valueOf(arr);
    }
}
