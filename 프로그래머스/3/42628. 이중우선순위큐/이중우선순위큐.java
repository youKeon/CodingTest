import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for (String str : operations) {
            if (str.charAt(0) == 'I') {
                int num = Integer.parseInt(str.substring(2));
                minQ.offer(num);
                maxQ.offer(num);
            } else {
                if (!minQ.isEmpty()) {
                    if (str.charAt(2) == '1') {
                        minQ.remove(maxQ.remove());
                    } else {
                        maxQ.remove(minQ.poll());
                    }
                }
            }
        }

        if (minQ.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxQ.poll(), minQ.poll()};
        }
    }
}