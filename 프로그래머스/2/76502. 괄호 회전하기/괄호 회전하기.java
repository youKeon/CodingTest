import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String s) {
        int ans = 0;
        Stack<Character> stack = new Stack();
        List<Character> list = new ArrayList<>();
        Queue<Character> q = new LinkedList();
        
        for (int i = 0; i < s.length(); i++) q.add(s.charAt(i));
        
        for (int j = 0; j < s.length(); j++) {
            if (q.peek() == ']' || q.peek() == '}' || q.peek() == ')') {
                q.add(q.poll());
                continue;
            }
                
            list = q.stream().collect(Collectors.toList());
            boolean flag = true;
            for (int i = 0; i < q.size(); i++) {
                if (list.get(i) == ')') {
                    if (stack.size() == 0 || stack.peek() != '(') {
                        flag = false;
                        break;
                    } else stack.pop();
                }
                else if (list.get(i) == '}') {
                    if (stack.size() == 0 || stack.peek() != '{') {
                        flag = false;
                        break;
                    } else stack.pop();
                }
                else if (list.get(i) == ']') {
                    if (stack.size() == 0 || stack.peek() != '[') {
                        flag = false;
                        break;
                    } else stack.pop();
                } else stack.push(list.get(i));
            }
            if (flag && stack.size() == 0) ans++;
            stack.clear();
            q.add(q.poll());
        }
        if (ans == 0) return 0;
        else return ans;
    }
}