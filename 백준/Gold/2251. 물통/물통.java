import java.util.*;

class Main {
    static boolean[][][] visited;
    static Set<Integer> results;
    static int A, B, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        visited = new boolean[201][201][201];
        results = new HashSet<>();
        bfs(0, 0, C);
        List<Integer> answer = new ArrayList<>(results);
        Collections.sort(answer);
        for (int res : answer) {
            System.out.print(res + " ");
        }
    }

    private static void bfs(int a, int b, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b, c});
        visited[a][b][c] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ca = current[0];
            int cb = current[1];
            int cc = current[2];
            if (ca == 0) results.add(cc);
            moveWater(queue, ca, cb, cc, A, B, C);
        }
    }

    private static void moveWater(Queue<int[]> queue, int ca, int cb, int cc, int A, int B, int C) {
        // A -> B
        pour(queue, ca, cb, cc, Math.min(ca, B - cb), 'A', 'B');
        // A -> C
        pour(queue, ca, cb, cc, Math.min(ca, C - cc), 'A', 'C');
        // B -> A
        pour(queue, ca, cb, cc, Math.min(cb, A - ca), 'B', 'A');
        // B -> C
        pour(queue, ca, cb, cc, Math.min(cb, C - cc), 'B', 'C');
        // C -> A
        pour(queue, ca, cb, cc, Math.min(cc, A - ca), 'C', 'A');
        // C -> B
        pour(queue, ca, cb, cc, Math.min(cc, B - cb), 'C', 'B');
    }

    private static void pour(Queue<int[]> queue, int ca, int cb, int cc, int water, char from, char to) {
        int new_ca = ca, new_cb = cb, new_cc = cc;
        switch (from) {
            case 'A':
                new_ca -= water;
                break;
            case 'B':
                new_cb -= water;
                break;
            case 'C':
                new_cc -= water;
                break;
        }
        switch (to) {
            case 'A':
                new_ca += water;
                break;
            case 'B':
                new_cb += water;
                break;
            case 'C':
                new_cc += water;
                break;
        }
        if (!visited[new_ca][new_cb][new_cc]) {
            visited[new_ca][new_cb][new_cc] = true;
            queue.add(new int[]{new_ca, new_cb, new_cc});
        }
    }
}