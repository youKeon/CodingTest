import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        
        for (char c : arr) {
            if (stack.isEmpty()) stack.push(c);
            else if (stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        if (!stack.isEmpty()) return 0;
        else return 1;
    }
}