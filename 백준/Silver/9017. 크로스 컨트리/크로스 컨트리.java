import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        Map<Integer, Integer> teamScore = new HashMap<>();
        Map<Integer, Integer> teamCount = new HashMap<>();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] score = new int[n];
            int[] lastScore = new int[201];

            for (int i = 0; i < n; i++) {
                score[i] = Integer.parseInt(st.nextToken());
                teamCount.put(score[i], teamCount.getOrDefault(score[i], 0) + 1);
            }

            for (Integer i : teamCount.keySet()) {
                if (teamCount.get(i) < 6) {
                    teamCount.put(i, -1);
                } else {
                    teamCount.put(i, 0);
                }
            }

            int grade = 1;
            for (int i : score) {
                if (teamCount.get(i) != -1) {
                    if (teamCount.get(i) == 4) {
                        if (lastScore[i] == 0) {
                            lastScore[i] = grade;
                        }
                        grade++;
                    } else {
                        teamScore.put(i, teamScore.getOrDefault(i, 0) + grade++);
                        teamCount.put(i, teamCount.get(i) + 1);
                    }
                }
            }

            int winner = 0;
            int min = Integer.MAX_VALUE;
            for (Integer key : teamScore.keySet()) {
                if (teamScore.get(key) == min && lastScore[winner] > lastScore[key]) {
                    winner = key;
                } else if (teamScore.get(key) < min) {
                    min = teamScore.get(key);
                    winner = key;
                }
            }
            bw.write(String.valueOf(winner));
            bw.newLine();

            teamCount.clear();
            teamScore.clear();
        }
        bw.close();
        br.close();
    }
}