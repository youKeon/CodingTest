import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static boolean[][] map;
    static int[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to] = true;
            map[to][from] = true;
        }

        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int result = bfs(i);

            if (list.isEmpty()) {
                list.add(i);
                min = result;
                continue;
            }

            if (min == result) list.add(i);
            else if (min > result) {
                list.clear();
                list.add(i);
                min = result;
            }
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(0));
    }

    private static int bfs(int from) {
        Deque<Integer> dq = new ArrayDeque<>();
        isVisited = new int[N + 1];
        Arrays.fill(isVisited, -1);
        isVisited[from] = 0;
        dq.offer(from);
        int result = 0;

        while (!dq.isEmpty()) {
            Integer cur = dq.poll();
            for (int i = 1; i <= N; i++) {
                if (i != cur && isVisited[i] == -1 && map[cur][i]) {
                    isVisited[i] = isVisited[cur] + 1;
                    dq.offer(i);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            result += isVisited[i];
        }
        return result;
    }
}