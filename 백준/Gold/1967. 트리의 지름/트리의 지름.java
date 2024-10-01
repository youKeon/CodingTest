import java.io.*;
import java.util.*;

class Main {
    static int n, answer;
    static ArrayList<Node>[] list;
    static boolean[] isVisited;

    static class Node {
        int l;
        int val;

        public Node(int l, int val) {
            this.l = l;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, val));
            list[to].add(new Node(from, val));
        }

        for (int i = 1; i <= n; i++) {
            isVisited = new boolean[n + 1];
            isVisited[i] = true;
            dfs(i, 0);
        }
        System.out.print(answer);
    }

    private static void dfs(int l, int total) {
        answer = Math.max(answer, total);

        for (Node node : list[l]) {
            if (!isVisited[node.l]) {
                isVisited[node.l] = true;
                dfs(node.l, total + node.val);
            }
        }
    }
}