import java.io.*;
import java.util.*;

class Main {
    static int N, removed, answer;
    static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) lists[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) root = i;
            else lists[parent].add(i);
        }
        removed = Integer.parseInt(br.readLine());

        if (removed == root) {
            System.out.print(0);
            return;
        }

        dfs(root);

        System.out.print(answer);
    }

    private static boolean dfs(int node) {
        if (node == removed) {
            return false;
        }

        if (lists[node].isEmpty()) {
            answer++;
            return true;
        }

        boolean isLeaf = true;
        for (int child : lists[node]) {
            if (dfs(child)) {
                isLeaf = false;
            }
        }

        if (isLeaf) {
            answer++;
        }

        return true;
    }
}