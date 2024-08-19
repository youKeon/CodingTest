import java.util.*;

class Main {
    static int[] choices;
    static boolean[] visited;
    static boolean[] inTeam;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(); // 학생의 수
            choices = new int[n + 1];
            visited = new boolean[n + 1];
            inTeam = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                choices[i] = sc.nextInt();
            }

            int notInTeam = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            for (int i = 1; i <= n; i++) {
                if (!inTeam[i]) {
                    notInTeam++;
                }
            }

            System.out.println(notInTeam);
        }
        sc.close();
    }

    static void dfs(int start) {
        int current = start;
        ArrayList<Integer> path = new ArrayList<>();

        while (!visited[current]) {
            visited[current] = true;
            path.add(current);
            current = choices[current];
        }

        // 사이클 찾기
        int cycleStart = current;
        boolean inCycle = false;
        for (int student : path) {
            if (student == cycleStart) {
                inCycle = true;
            }
            if (inCycle) {
                inTeam[student] = true;
            }
        }
    }
}