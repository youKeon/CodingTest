import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 100000 + 10;
    static int n, idx;
    static boolean[] chk;
    static int[] ans;
    static ArrayList<Integer>[] arr;

    static void dfs(int l) {
        chk[l] = true;
        for (int i = 0; i < arr[l].size(); i++) {
            int tmp = arr[l].get(i);
            if (!chk[tmp]) {
                ans[tmp] = l;
                dfs(tmp);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList[MAX];
        chk = new boolean[MAX];
        ans = new int[MAX];

        for (int i = 1; i <= n; i++) arr[i] = new ArrayList();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!chk[i]) {
                dfs(i);
            }
        }
        for (int i = 2; i <= n; i++) {
            bw.write(String.valueOf(ans[i]));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}