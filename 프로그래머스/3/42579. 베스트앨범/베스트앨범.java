import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> playCount = new HashMap<>();
        Map<String, Map<Integer, Integer>> gMap = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            int play = plays[i];
            String genre = genres[i];

            playCount.put(genre, playCount.getOrDefault(genre, 0) + play);
            if (gMap.containsKey(genre)) gMap.get(genre).put(i, play);
            else {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, play);
                gMap.put(genre, map);
            }
        }

        List<String> maxPlay = new ArrayList<>(playCount.keySet());
        maxPlay.sort((o1, o2) -> playCount.get(o2) - playCount.get(o1));
        for (String key : maxPlay) {
            Map<Integer, Integer> map = gMap.get(key);
            List<Integer> tmp = new ArrayList<>(map.keySet());
            tmp.sort((o1, o2) -> map.get(o2) - map.get(o1));
            ans.add(tmp.get(0));
            if (tmp.size() > 1) ans.add(tmp.get(1));
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}