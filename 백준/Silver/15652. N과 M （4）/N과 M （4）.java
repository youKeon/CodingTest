import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(0, 0);
        System.out.print(sb);
    }

    private static void dfs(int depth, int pre) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = pre; i < N; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1, i);
        }
    }
}
