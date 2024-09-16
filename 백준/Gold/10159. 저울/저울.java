import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static ArrayList<Integer>[] heavier, lighter;
    static int[] heavierCount, lighterCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        heavier = new ArrayList[N + 1];
        lighter = new ArrayList[N + 1];
        heavierCount = new int[N + 1];
        lighterCount = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            heavier[i] = new ArrayList<>();
            lighter[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            heavier[b].add(a);
            lighter[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            dfs(i, heavier, new boolean[N + 1], heavierCount);
            dfs(i, lighter, new boolean[N + 1], lighterCount);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(N - 1 - (heavierCount[i] + lighterCount[i])).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int node, ArrayList<Integer>[] graph, boolean[] visited, int[] count) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                count[next]++;
                dfs(next, graph, visited, count);
            }
        }
    }
}