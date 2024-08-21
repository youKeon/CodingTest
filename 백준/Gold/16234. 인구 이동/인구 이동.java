import java.io.*;
import java.util.*;

class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            boolean flag = true;
            isVisited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j]) {
                        Set<Node> nodes = bfs(i, j);
                        if (!nodes.isEmpty()) {
                            flag = false;
                            move(nodes);
                        }
                    }
                }
            }
            if (flag) break;
            ans++;
        }
        System.out.print(ans);
    }

    private static Set<Node> bfs(int y, int x) {
        Deque<Node> dq = new ArrayDeque<>();
        Set<Node> nodes = new HashSet<>();
        dq.offer(new Node(y, x));
        isVisited[y][x] = true;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !isVisited[ny][nx]) {
                    int diff = Math.abs(map[cur.y][cur.x] - map[ny][nx]);
                    Node next = new Node(ny, nx);

                    if (diff >= L && diff <= R) {
                        isVisited[ny][nx] = true;
                        nodes.add(next);
                        nodes.add(cur);
                        dq.offer(next);
                    }
                }
            }
        }
        return nodes;
    }

    private static void move(Set<Node> nodes) {
        int sum = 0;

        for (Node node : nodes) {
            sum += map[node.y][node.x];
        }

        int mid = sum / nodes.size();

        for (Node node : nodes) {
            map[node.y][node.x] = mid;
        }
    }
}
