import java.util.*;
import java.io.*;

class Main {
    static String[] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr = new String[10000 + 3];
            isVisited = new boolean[10000 + 3];
            Arrays.fill(arr, "");

            bfs(from, to);

            bw.write(arr[to]);
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    private static void bfs(int from, int to) {
        Queue<Integer> q = new LinkedList<>();
        isVisited[from] = true;
        q.add(from);

        while (!q.isEmpty() && !isVisited[to]) {
            Integer cur = q.poll();
            int D = cur * 2 > 9999 ? (cur * 2) % 10000 : cur * 2;
            int S = cur == 0 ? 9999 : cur - 1;
            int L = (cur % 1000) * 10 + (cur / 1000);
            int R = (cur % 10) * 1000 + (cur / 10);

            if (!isVisited[D]) {
                isVisited[D] = true;
                arr[D] = arr[cur] + "D";
                q.add(D);
            }

            if (!isVisited[S]) {
                isVisited[S] = true;
                arr[S] = arr[cur] + "S";
                q.add(S);
            }

            if (!isVisited[L]) {
                isVisited[L] = true;
                arr[L] = arr[cur] + "L";
                q.add(L);
            }

            if (!isVisited[R]) {
                isVisited[R] = true;
                arr[R] = arr[cur] + "R";
                q.add(R);
            }
        }
    }
}
