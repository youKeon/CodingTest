import java.io.*;
import java.util.*;

class Main {
    static int N, ans;
    static int[] cost, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        time = new int[N];
        cost = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        dfs(0, 0);

        System.out.print(ans);
    }

    private static void dfs(int day, int total) {
        if (day >= N) {
            ans = Math.max(ans, total);
            return;
        }

        if (day + time[day] <= N) {
            dfs(day + time[day], total + cost[day]);
        }

        dfs(day + 1, total);
    }
}