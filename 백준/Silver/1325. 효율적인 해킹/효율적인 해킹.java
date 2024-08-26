import java.io.*;
import java.util.*;

class Main {
    static int N, M, count;
    static List<Integer>[] lists;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[b].add(a);
        }

        int max = Integer.MIN_VALUE;
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            count = 1;
            isVisited = new boolean[N + 1];
            isVisited[i] = true;

            dfs(i, 1);

            if (answer.isEmpty()) {
                max = count;
                answer.add(i);
            } else if (max < count) {
                answer.clear();
                max = count;
                answer.add(i);
            } else if (max == count) {
                answer.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        answer.sort(Comparator.naturalOrder());
        for (Integer i : answer) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }

    private static void dfs(int l, int depth) {
        if (depth == N) {
            count = depth;
            return;
        }

        for (Integer i : lists[l]) {
            if (!isVisited[i]) {
                count++;
                isVisited[i] = true;
                dfs(i, depth + 1);
            }
        }
    }
}