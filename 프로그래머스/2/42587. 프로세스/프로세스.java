import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            dq.offer(i);
            list.add(priorities[i]);
        }

        list.sort(Comparator.reverseOrder());
        int count = 0;

        while (dq.contains(location)) {
            int index = dq.poll();

            if (list.get(0) == priorities[index]) {
                list.remove(0);
                count++;
            } else {
                dq.offerLast(index);
            }
        }
        return count;
    }
}