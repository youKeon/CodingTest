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

        map = new char[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            isVisited[i][0] = true;
            if (isAble(i, 0)) answer++;
        }
        System.out.print(answer);
    }

    private static boolean isAble(int y, int x) {
        if (x == C - 1) return true;

        for (int[] i : dir) {
            int ny = y + i[0];
            int nx = x + i[1];

            if (ny >= 0 && ny < R && nx >= 0 && nx < C && !isVisited[ny][nx] && map[ny][nx] == '.') {
                isVisited[ny][nx] = true;
                if (isAble(ny, nx)) return true;
            }
        }
        return false;
    }
}