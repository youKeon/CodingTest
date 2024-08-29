import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] isVisited;
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};

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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R + 1][C + 1];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i + 1][j + 1] = line.charAt(j);
            }
        }

        isVisited = new boolean[R + 1][C + 1];
        int answer = 0;
        for (int i = 1; i <= R; i++) {
            if (dfs(i, 1)) answer++;
        }
        System.out.print(answer);
    }

    private static boolean dfs(int y, int x) {
        if (x == C) return true;

        for (int[] d : dir) {
            int ny = y + d[0];
            int nx = x + d[1];

            if (ny >= 1 && ny <= R && nx >= 1 && nx <= C && !isVisited[ny][nx] && map[ny][nx] == '.') {
                isVisited[ny][nx] = true;
                if (dfs(ny, nx)) return true;
            }
        }
        return false;
    }
}