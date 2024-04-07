import java.util.*;
import java.io.*;

class Main {
    static String[] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            isVisited = new boolean[10000];
            arr = new String[10000];
            Arrays.fill(arr,  "");

            bfs(from, to);

            System.out.println(arr[to]);
        }
    }

    private static void bfs(int from, int to) {
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        isVisited[from] = true;

        while (!q.isEmpty() && !isVisited[to]) {
            int cur = q.poll();

            int D = (2 * cur) % 10000;
            int S = cur == 0 ? 9999 : cur - 1;
            int L = (cur % 1000) * 10 + cur / 1000;
            int R = (cur % 10) * 1000 + cur / 10;

            if (!isVisited[D]) {
                q.add(D);
                isVisited[D] = true;
                arr[D] = arr[cur] + "D";
            }

            if (!isVisited[S]) {
                q.add(S);
                isVisited[S] = true;
                arr[S] = arr[cur] + "S";
            }

            if (!isVisited[L]) {
                q.add(L);
                isVisited[L] = true;
                arr[L] = arr[cur] + "L";
            }

            if (!isVisited[R]) {
                q.add(R);
                isVisited[R] = true;
                arr[R] = arr[cur] + "R";
            }
        }
    }
}

/**
 * D, S, L, R 명령어가 있는 계산기
 * 계산기에 있는 레지스터리는 0 이상 10000 미만의 십진수 저장
 * D : n * 2, 결과 값이 9999보다 크면 10000으로 나눈 나머지를 저장
 * S : n - 1, 결과 값이 0이면 9999 저장
 * L :
 *
 */