import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static char[][] map;
    static int[][] status;  // 0: 미방문, 1: 방문 중, 2: SAFE ZONE
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        status = new int[N][M];
        answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (status[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y) {
        if (status[x][y] == 2) return; 
        if (status[x][y] == 1) {  
            status[x][y] = 2;
            answer++;
            return;
        }

        status[x][y] = 1;  

        int nx = x, ny = y;
        switch (map[x][y]) {
            case 'U': nx--; break;
            case 'D': nx++; break;
            case 'L': ny--; break;
            case 'R': ny++; break;
        }
        
        dfs(nx, ny);
        
        if (status[nx][ny] == 2) status[x][y] = 2;
    }
}