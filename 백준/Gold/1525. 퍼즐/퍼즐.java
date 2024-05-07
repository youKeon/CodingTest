import java.util.*;
import java.io.*;

class Main {
    static final String ANS = "123456780";
    static Map<String, Integer> hashMap = new HashMap();
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new int[9][9];
        String init = "";
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                init += map[i][j];
            }
        }

        int count = bfs(init);
        System.out.print(count);
    }

    private static int bfs(String init) {
        Queue<String> q = new LinkedList<>();
        q.add(init);
        hashMap.put(init, 0);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals(ANS)) {
                return hashMap.get(cur);
            }

            int zeroIdx = cur.indexOf("0");
            int y = zeroIdx / 3;
            int x = zeroIdx % 3;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (isValidZone(ny, nx)) {
                    int nextIdx = (ny * 3) + nx;
                    String nextString = swap(cur, nextIdx);

                    if (!hashMap.containsKey(nextString)) {
                        hashMap.put(nextString, hashMap.get(cur) + 1);
                        q.add(nextString);
                    }
                }
            }
        }
        return -1;
    }

    private static String swap(String cur, int nextIdx) {
        char target = cur.charAt(nextIdx);
        String nextString = cur.replace(target, '-');
        nextString = nextString.replace('0', target);
        nextString = nextString.replace('-', '0');
        return nextString;
    }

    private static boolean isValidZone(int ny, int nx) {
        return ny >= 0 && ny < 3 && nx >= 0 && nx < 3;
    }
}
