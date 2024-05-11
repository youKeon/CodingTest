import java.util.*;
import java.io.*;

class Main {
    static long A, B;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        long ans = bfs();

        System.out.print(ans);
    }

    private static int bfs() {
        Queue<Long> q = new LinkedList<>();
        int result = 0;
        q.add(A);

        while (!q.isEmpty()) {
            result++;
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Long cur = q.poll();

                if (cur == B) return result;
                if (cur > B) continue;

                q.add(cur * 2);
                q.add((cur * 10) + 1);
            }
        }
        return -1;
    }
}
