import java.io.*;
import java.util.*;

class Main {
    static int F, G, S, U, D;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // total
        S = Integer.parseInt(st.nextToken()); // cur
        G = Integer.parseInt(st.nextToken()); // goal
        U = Integer.parseInt(st.nextToken()); // up
        D = Integer.parseInt(st.nextToken()); // down
        arr = new int[F + 1];

        int result = bfs();
        if (result == -1) System.out.println("use the stairs");
        else System.out.print(result);
    }

    private static int bfs() {
        Deque<Integer> dq = new ArrayDeque<>();
        Arrays.fill(arr, -1);
        dq.offer(S);
        arr[S] = 0;

        while (!dq.isEmpty()) {
            Integer cur = dq.poll();

            if (cur == G) return arr[cur];

            int up = cur + U;
            int down = cur - D;

            if (up <= F && arr[up] == -1) {
                dq.offer(up);
                arr[up] = arr[cur] + 1;
            }

            if (down > 0 && arr[down] == -1) {
                dq.offer(down);
                arr[down] = arr[cur] + 1;
            }
        }
        return -1;
    }
}