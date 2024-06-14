import java.util.*;

class Solution {
    String begin;
    String target;
    String[] words;
    Map<String, Integer> map;
    
    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        this.map = new HashMap<>();
        
        return bfs();
    }
    
    private int bfs() {
        Deque<String> dq = new ArrayDeque<>();
        dq.add(begin);
        map.put(begin, 0);
        
        while (!dq.isEmpty()) {
            String cur = dq.poll();
            
            if (cur.equals(target)) {
                return map.get(cur);
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!map.containsKey(words[i]) && isAble(cur, words[i])) {
                    dq.add(words[i]);
                    map.put(words[i], map.get(cur) + 1);
                }
            }
        }
        return 0;
    }
    
    private boolean isAble(String word, String target) {
        int count = 0;
        
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                count++;
                
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}