import java.io.*;
import java.util.*;

class Main {
    static String from;
    static String to;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        from = br.readLine();
        to = br.readLine();

        System.out.println(bfs());
    }

    static int bfs() {
        Deque<String> dq = new ArrayDeque<>();
        Set<String> set = new HashSet<>();

        dq.offer(to);
        set.add(to);

        while (!dq.isEmpty()) {
            String cur = dq.poll();

            if (cur.equals(from)) {
                return 1;
            }

            if (cur.endsWith("A")) {
                String tmp = cur.substring(0, cur.length() - 1);

                if (!set.contains(tmp)) {
                    set.add(tmp);
                    dq.offer(tmp);
                }
            }

            if (cur.startsWith("B")) {
                String tmp = new StringBuilder(cur.substring(1)).reverse().toString();
                if (!set.contains(tmp)) {
                    set.add(tmp);
                    dq.offer(tmp);
                }
            }
        }
        return 0;
    }
}