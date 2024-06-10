import java.util.*;

class Solution {
    public String solution(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        
        list.sort(Comparator.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}