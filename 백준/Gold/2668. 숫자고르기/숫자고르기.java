import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static boolean[] isVisited;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N + 1];
            isVisited[i] = true;
            dfs(i, i);
        }

        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append("\n");
        for (Integer i : list) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int l, int from) {
        if (arr[l] == from) {
            list.add(l);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isVisited[arr[l]]) {
                isVisited[arr[l]] = true;
                dfs(arr[l], from);
            }
        }
    }
}