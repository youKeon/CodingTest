import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] graph;
    static int[] colors;
    static final int UNCOLORED = 0;
    static final int RED = 1;
    static final int BLUE = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); 

        for (int t = 0; t < K; t++) {
            int V = sc.nextInt(); 
            int E = sc.nextInt();

            graph = new ArrayList[V + 1];
            colors = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            boolean isBipartite = true;
            for (int i = 1; i <= V; i++) {
                if (colors[i] == UNCOLORED) {
                    if (!dfs(i, RED)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
        sc.close();
    }

    static boolean dfs(int v, int color) {
        colors[v] = color;
        for (int neighbor : graph[v]) {
            if (colors[neighbor] == color) {
                return false;
            }
            if (colors[neighbor] == UNCOLORED && !dfs(neighbor, 3 - color)) {
                return false;
            }
        }
        return true;
    }
}