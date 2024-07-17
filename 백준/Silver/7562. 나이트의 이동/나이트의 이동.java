import java.io.*;
import java.util.*;

class Main {
    static int l;
    static int[][] map;
    static int[] dy = {-1, -2, -1, -2, 1, 2, 1, 2};
    static int[] dx = {-2, -1, 2, 1, -2, -1, 2, 1};

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

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];

            st = new StringTokenizer(br.readLine());
            int fromY = Integer.parseInt(st.nextToken());
            int fromX = Integer.parseInt(st.nextToken());
            Node start = new Node(fromY, fromX);

            st = new StringTokenizer(br.readLine());
            int toY = Integer.parseInt(st.nextToken());
            int toX = Integer.parseInt(st.nextToken());
            map[toY][toX] = 1;

            int ans = bfs(start);
            System.out.println(ans);
        }
    }

    private static int bfs(Node start) {
        Deque<Node> dq = new ArrayDeque<>();
        map[start.y][start.x] = -1;
        dq.offer(start);
        int ans = 0;

        while (!dq.isEmpty()) {
            int len = dq.size();
            ans++;

            while (len-- > 0) {
                Node cur = dq.poll();
                for (int i = 0; i < 8; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    if (ny >= 0 && ny < l && nx >= 0 && nx < l) {
                        if (map[ny][nx] == 1) return ans;
                        if (map[ny][nx] == 0) {
                            dq.offer(new Node(ny, nx));
                            map[ny][nx] = -1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}