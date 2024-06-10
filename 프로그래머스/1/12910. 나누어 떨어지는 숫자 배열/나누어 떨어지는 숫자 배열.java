import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (i % divisor == 0) {
                list.add(i);
            }
        }
        
        if (list.size() == 0) {
            return new int[]{-1};
        }
        list.sort(Comparator.naturalOrder());
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}