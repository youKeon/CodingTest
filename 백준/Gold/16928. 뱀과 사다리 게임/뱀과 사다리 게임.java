import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] map;
    static int[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[101];
        isVisited = new int[101];
        Arrays.fill(isVisited, -1);


        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int answer = bfs();
        System.out.print(answer);
    }

    private static int bfs() {
        Deque<Integer> dq = new ArrayDeque<>();
        isVisited[1] = 0;
        dq.offer(1);

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            if (cur == 100) return isVisited[cur];

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;

                if (next <= 100) {
                    if (map[next] != 0) {
                        next = map[next];
                    }

                    if (isVisited[next] == -1) {
                        isVisited[next] = isVisited[cur] + 1;
                        dq.offer(next);
                    }
                }
            }
        }
        return 0;
    }
}