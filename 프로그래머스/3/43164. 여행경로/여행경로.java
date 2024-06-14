import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        List<String> route = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("ICN");

        // DFS 탐색
        while (!stack.isEmpty()) {
            String current = stack.peek();
            if (graph.containsKey(current) && !graph.get(current).isEmpty()) {
                stack.push(graph.get(current).poll());
            } else {
                route.add(stack.pop());
            }
        }

        // 결과를 배열로 변환하여 반환
        Collections.reverse(route);
        return route.toArray(new String[0]);
    }
}