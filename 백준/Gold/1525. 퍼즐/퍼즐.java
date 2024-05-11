import java.io.*;
import java.util.*;

class Main {
    static final String ANSWER = "123456780";
    static Map<String, Integer> isVisited = new HashMap<>();
    static String[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new String[9][9];
        String init = "";
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = st.nextToken();
                init += map[i][j];
            }
        }

        int result = bfs(init);
        System.out.print(result);
    }

    private static int bfs(String init) {
        Queue<String> q = new LinkedList<>();
        isVisited.put(init, 0);
        q.add(init);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals(ANSWER)) return isVisited.get(cur);
            int indexOfZero = cur.indexOf("0");
            int y = indexOfZero / 3;
            int x = indexOfZero % 3;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (isValid(ny, nx)) {
                    String nextString = swap(cur, ny, nx);

                    if (!isVisited.containsKey(nextString)) {
                        q.add(nextString);
                        isVisited.put(nextString, isVisited.get(cur) + 1);
                    }
                }
            }
        }
        return -1;
    }

    private static String swap(String cur, int ny, int nx) {
        char target = cur.charAt((ny * 3) + nx);
        String nextString = cur.replace(target, '-');
        nextString = nextString.replace('0', target);
        nextString = nextString.replace('-', '0');
        return nextString;
    }

    private static boolean isValid(int ny, int nx) {
        return ny >= 0 && ny < 3 && nx >= 0 && nx < 3;
    }
}