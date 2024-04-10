import java.util.*;
import java.io.*;

class Main {
    static String target = "123456780";
    static String statement;
    static Map<String, Integer> map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        statement = "";
        map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                statement += st.nextToken();
            }
        }
        map.put(statement, 0);
        int ans = bfs(statement);
        System.out.print(ans);
    }

    private static int bfs(String start) {
        Queue<String> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            String cur = q.poll().toString();
            if (cur.equals(target)) return map.get(cur);

            int zeroIdx = cur.indexOf("0");
            int row = zeroIdx / 3;
            int col = zeroIdx % 3;

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                if (nextRow >= 0 && nextRow < 3 && nextCol >= 0 && nextCol < 3) {
                    int nextZeroIdx = nextRow * 3 + nextCol;
                    char nextIdxCharacter = cur.charAt(nextZeroIdx);
                    String nextString = cur.replace(nextIdxCharacter, 'n');
                    nextString = nextString.replace('0', nextIdxCharacter);
                    nextString = nextString.replace('n', '0');

                    if (!map.containsKey(nextString)) {
                        q.add(nextString);
                        map.put(nextString, map.get(cur) + 1);
                    }
                }
            }
        }
        return -1;
    }
}
