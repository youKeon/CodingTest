import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static ArrayList<Integer>[] heavy, light;
    static int[] hCount, lCount;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        heavy = new ArrayList[N + 1];
        light = new ArrayList[N + 1];
        hCount = new int[N + 1];
        lCount = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            heavy[i] = new ArrayList<>();
            light[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            heavy[b].add(a);
            light[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N + 1];
            isVisited[i] = true;
            
            dfs(i, heavy, hCount);
            dfs(i, light, lCount);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(N - 1 - (hCount[i] + lCount[i])).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int l, ArrayList<Integer>[] graph, int[] count) {
        for (int next : graph[l]) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                count[next]++;
                dfs(next, graph, count);
            }
        }
    }
}