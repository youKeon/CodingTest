import java.util.*;

class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        while (true) {
            int next = Integer.bitCount(++n);
            if (count == next) return n;
        }
    }
}