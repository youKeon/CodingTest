import java.util.*;
import java.io.*;

class Main {
    static int[] num, op;
    static int n, min, max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        op = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) op[i] = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        dfs(1, num[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int l, int total) {
        if (l == n) {
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        for (int i = 0; i < op.length; i++) {
            if (op[i] > 0) {
                op[i]--;
                if (i == 0) dfs(l + 1, total + num[l]);
                else if (i == 1) dfs(l + 1, total - num[l]);
                else if (i == 2) dfs(l + 1, total * num[l]);
                else dfs(l + 1, total / num[l]);
                op[i]++;
            }
        }
    }
}
