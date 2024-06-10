import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new LinkedList<>();
        int min = Integer.MAX_VALUE;

        for (int i : arr) {
            list.add(i);
            min = Math.min(min, i);
        }

        list.remove((Object) min);
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}