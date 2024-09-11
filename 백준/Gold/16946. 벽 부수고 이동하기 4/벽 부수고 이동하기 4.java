import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] map;
    static int[][] group;
    static Map<Integer, Integer> groupSize = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        group = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int groupId = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && group[i][j] == 0) {
                    bfs(i, j, groupId++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    sb.append(getCount(i, j));
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int x, int y, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        group[x][y] = id;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && group[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    group[nx][ny] = id;
                    size++;
                }
            }
        }
        groupSize.put(id, size);
    }

    static int getCount(int x, int y) {
        Set<Integer> connectedGroups = new HashSet<>();
        int result = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && group[nx][ny] != 0) {
                connectedGroups.add(group[nx][ny]);
            }
        }

        for (int groupId : connectedGroups) {
            result += groupSize.get(groupId);
        }

        return result % 10;
    }
}