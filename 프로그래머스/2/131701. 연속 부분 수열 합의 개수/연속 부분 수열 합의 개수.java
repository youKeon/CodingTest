import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            arr[i] = arr[i + elements.length] = elements[i];
        }

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = Arrays.stream(arr, j, j + i).sum();
                set.add(sum);
            }
        }

        return set.size();
    }
}