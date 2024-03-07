import java.util.*;

class Solution {
    Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for (int i : course) {
            for (String order : orders) {
                dfs(i, order, "");
            }

            if (map.size() <= 0) continue;
            List<String> keySet = new ArrayList<>(map.keySet());
            keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));
            int max = map.get(keySet.get(0));

            if (max >= 2) {
                for (String s : keySet) {
                    if (map.get(s) == max) list.add(s);
                }
            }
            map.clear();
        }
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }

    private void dfs(int l, String order, String combination) {
        if (l == 0) {
            map.put(combination, map.getOrDefault(combination, 0) + 1);
            return;
        }

        for (int i = 0; i < order.length(); i++) {
            char tmp = order.charAt(i);
            dfs(l - 1, order.substring(i + 1), combination + tmp);
        }
    }
}