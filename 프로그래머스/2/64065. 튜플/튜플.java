import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "-");
        String[] arr = s.split("-");
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String[] tmp = arr[i].split(",");
            
            for (String str : tmp) {
                int num = Integer.parseInt(str);
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}