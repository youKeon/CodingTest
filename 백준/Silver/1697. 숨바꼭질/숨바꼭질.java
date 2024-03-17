import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 100000 + 10;
    static int n, m;
    static int[] location;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        location = new int[MAX];
        Arrays.fill(location, -1);

        bfs();

        System.out.print(location[m]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        location[n] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : new int[]{cur + 1, cur - 1, cur * 2}) {
                if (i >= 0 && i < MAX && location[i] == -1) {
                    q.add(i);
                    location[i] = location[cur] + 1;
                }
            }
        }
    }
}

