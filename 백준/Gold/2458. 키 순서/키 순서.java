import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[b][a] = 1;
            map[a][b] = 2;
        }

        int answer = 0;
        for (int i = 1; i <= N ; i++) {
            isVisited = new boolean[N + 1];
            isVisited[i] = true;

            dfs(i, 1);
            dfs(i, 2);

            if (isKnown(i)) {
                answer++;
            }
        }
        System.out.print(answer);
    }

    private static void dfs(int l, int target) {
        for (int i = 1; i <= N; i++) {
            if (!isVisited[i] && map[l][i] == target) {
                isVisited[i] = true;
                dfs(i, target);
            }
        }
    }

    private static boolean isKnown(int l) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
//            if (i != l && (map[l][i] == 2 || map[l][i] == 1)) {
//                count++;
//            }
            if (isVisited[i]) count++;
        }
        return count == N;
    }
}

/**
 * i가 가리키는 번호 : i보다 큰 사람
 * i를 가리키는 번호 : i보다 작은 사람
 * 둘을 더해서 N이면 순번을 아는 학생
 *
 * 자신을 가리키는 번호를 dfs로 순
 */