import java.io.*;
import java.util.*;

class Team implements Comparable<Team> {
    int id;
    int totalScore;
    int submitCount;
    int lastSubmitTime;

    public Team(int id) {
        this.id = id;
        this.totalScore = 0;
        this.submitCount = 0;
        this.lastSubmitTime = 0;
    }

    @Override
    public int compareTo(Team other) {
        if (this.totalScore != other.totalScore) {
            return other.totalScore - this.totalScore; // 높은 점수 우선
        }
        if (this.submitCount != other.submitCount) {
            return this.submitCount - other.submitCount; // 제출 횟수 적은 팀 우선
        }
        return this.lastSubmitTime - other.lastSubmitTime; // 마지막 제출 시간이 빠른 팀 우선
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n + 1];
            for (int i = 1; i <= n; i++) {
                teams[i] = new Team(i);
            }

            int[][] scores = new int[n + 1][k + 1];

            for (int logEntry = 0; logEntry < m; logEntry++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (score > scores[teamId][problemId]) {
                    teams[teamId].totalScore += score - scores[teamId][problemId];
                    scores[teamId][problemId] = score;
                }
                teams[teamId].submitCount++;
                teams[teamId].lastSubmitTime = logEntry;
            }

            Arrays.sort(teams, 1, n + 1);

            for (int rank = 0; rank < n; rank++) {
                if (teams[rank + 1].id == t) {
                    result.append(rank + 1).append("\n");
                    break;
                }
            }
        }

        System.out.print(result.toString());
    }
}
