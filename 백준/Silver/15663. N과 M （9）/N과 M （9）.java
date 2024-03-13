import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] chk;
    static int[] arr, tmp;

    static void dfs(int l) {
        if (l == m) {
            for (int i : tmp) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (!chk[i] && arr[i] != pre) {
                chk[i] = true;
                tmp[l] = arr[i];
                pre = arr[i];
                dfs(l + 1);
                chk[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        chk = new boolean[n];
        tmp = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        dfs(0);

        System.out.print(sb);
    }
}