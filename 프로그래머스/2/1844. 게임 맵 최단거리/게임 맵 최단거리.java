import java.util.*;

class Solution {
    int[][] isVisited;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        this.isVisited = new int[maps.length][maps[0].length];
        for (int[] b : isVisited) {
            Arrays.fill(b, -1);
        }
        bfs(maps);
        return isVisited[isVisited.length - 1][isVisited[0].length - 1];
    }

    private int bfs(int[][] maps) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});
        isVisited[0][0] = 1;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur[0];
                int nx = dx[i] + cur[1];

                if (ny >= 0 && ny < maps.length &&
                        nx >= 0 && nx < maps[0].length &&
                        maps[ny][nx] == 1 && isVisited[ny][nx] == -1) {
                    dq.offer(new int[]{ny, nx});
                    isVisited[ny][nx] = isVisited[cur[0]][cur[1]] + 1;
                }
            }
        }
        return 1;
    }
}