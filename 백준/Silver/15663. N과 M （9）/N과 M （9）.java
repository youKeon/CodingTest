import java.io.*;
import java.util.*;

class Main {
    static int[] arr, ans;
    static boolean[] isVisited;
    static StringBuilder sb;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N];
        sb = new StringBuilder();
        arr = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.print(sb);
    }

    private static void dfs(int l, int depth) {
        if (depth == M) {
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int pre = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] != pre && !isVisited[i]) {
                pre = arr[i];
                ans[depth] = arr[i];
                isVisited[i] = true;
                dfs(i, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}