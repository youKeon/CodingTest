import java.io.*;
import java.util.*;

class Main {
    static Map<String, Integer> countMap = new HashMap<>();
    static final String GOAL = "123456780";
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        map = new int[3][3];
        String init = "";

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                init += map[i][j];
            }
        }

        int ans = bfs(init);
        System.out.println(ans);
    }

    private static int bfs(String init) {
        Deque<String> dq = new ArrayDeque<>();

        countMap.put(init, 0);
        dq.offer(init);

        while (!dq.isEmpty()) {
            int len = dq.size();
            for (int i = 0; i < len; i++) {
                String cur = dq.poll();

                if (cur.equals(GOAL)) return countMap.get(cur);

                int idx = cur.indexOf('0');
                int y = idx / 3;
                int x = idx % 3;
                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];

                    if (ny >= 0 && ny < 3 && nx >= 0 && nx < 3) {
                        String tmp = swap(ny, nx, cur);
                        if (!countMap.containsKey(tmp)) {
                            dq.offer(tmp);
                            countMap.put(tmp, countMap.get(cur) + 1);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static String swap(int y, int x, String str) {
        int zeroIndex = str.indexOf('0');
        int nextIndex = (y * 3) + x;
        char nextChar = str.charAt(nextIndex);

        str = str.replace('0', '-');
        str = str.replace(nextChar, '0');
        str = str.replace('-', nextChar);
        return str;
    }
}