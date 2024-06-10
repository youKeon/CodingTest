import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        if (arr.length == 0) {
            return new int[]{};
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}