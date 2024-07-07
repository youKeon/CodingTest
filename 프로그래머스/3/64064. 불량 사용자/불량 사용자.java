import java.util.*;

class Solution {
    private Set<Set<String>> resultSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(new HashSet<>(), user_id, banned_id, 0);
        return resultSet.size();
    }
    
    private void dfs(Set<String> currentSet, 
                     String[] user_id, 
                     String[] banned_id, 
                     int index) {
        if (index == banned_id.length) {
            resultSet.add(new HashSet<>(currentSet));
            return;
        }

        String b = banned_id[index];
        for (String u : user_id) {
            if (b.length() == u.length()) {
                boolean isAble = true;
                for (int i = 0; i < b.length(); i++) {
                    if (b.charAt(i) != '*' && b.charAt(i) != u.charAt(i)) {
                        isAble = false;
                        break;
                    }
                }
                if (isAble && !currentSet.contains(u)) {
                    currentSet.add(u);
                    dfs(currentSet, user_id, banned_id, index + 1);
                    currentSet.remove(u);
                }
            }
        }
    }
}
