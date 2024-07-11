import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 30;
    static int N;
    static int[][] map;
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
        List<Integer> ans = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        map = new int[MAX][MAX];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i + 1][j + 1] = tmp.charAt(j) - '0';
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    int size = bfs(i, j);
                    ans.add(size);
                }
            }
        }
        ans.sort(Comparator.naturalOrder());
        System.out.println(ans.size());
        for (Integer i : ans) {
            System.out.println(i);
        }
    }

    private static int bfs(int y, int x) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(y, x));
        map[y][x] = 0;
        int result = 1;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (map[ny][nx] == 1) {
                    dq.offer(new Node(ny, nx));
                    map[ny][nx] = 0;
                    result++;
                }
            }
        }
        return result;
    }
}