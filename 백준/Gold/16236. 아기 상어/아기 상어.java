import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] map, isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static class Node {
        int y;
        int x;
        int dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    static class Shark extends Node {
        int size;
        int count;

        public Shark(int y, int x) {
            super(y, x, 0);
            this.size = 2;
            this.count = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        Shark shark = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }

        int ans = 0;
        while (true) {
            isVisited = new int[N][N];
            for (int[] i : isVisited) {
                Arrays.fill(i, -1);
            }
            Node result = bfs(shark);
            if (result.y == -1) break;
            shark.y = result.y;
            shark.x = result.x;
            ans += result.dist;

            if (++shark.count == shark.size) {
                shark.size++;
                shark.count = 0;
            }
            map[result.y][result.x] = 0;
        }
        System.out.println(ans);
    }

    private static Node bfs(Shark shark) {
        Deque<Node> dq = new ArrayDeque<>();
        List<Node> result = new ArrayList<>();
        dq.offer(new Node(shark.y, shark.x, 0));
        isVisited[shark.y][shark.x] = 0;
        int min = Integer.MAX_VALUE;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();

            if (cur.dist > min) break;

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && isVisited[ny][nx] == -1) {
                    isVisited[ny][nx] = isVisited[cur.y][cur.x] + 1;

                    if (map[ny][nx] == 0 || map[ny][nx] == shark.size) {
                        dq.offer(new Node(ny, nx, cur.dist + 1));
                    }
                    
                    if (map[ny][nx] != 0 && map[ny][nx] < shark.size) {
                        result.add(new Node(ny, nx, cur.dist + 1));
                        min = cur.dist;
                    }
                }
            }
        }
        if (result.isEmpty()) return new Node(-1, -1, -1);
        result.sort((o1, o2) -> {
            if (o1.dist != o2.dist) return o1.dist - o2.dist;
            if (o1.y != o2.y) return o1.y - o2.y;
            return o1.x - o2.x;
        });
        return result.get(0);
    }
}