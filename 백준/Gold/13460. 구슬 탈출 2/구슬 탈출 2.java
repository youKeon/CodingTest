import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, count;
        State(int rx, int ry, int bx, int by, int count) {
            this.rx = rx; this.ry = ry;
            this.bx = bx; this.by = by;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i; by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        queue.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.count >= 10) return -1;  // 10번 이상 움직였으면 -1 반환

            for (int i = 0; i < 4; i++) {
                int nrx = cur.rx, nry = cur.ry;
                int nbx = cur.bx, nby = cur.by;

                while (board[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];
                    if (board[nrx][nry] == 'O') break;
                }

                while (board[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];
                    if (board[nbx][nby] == 'O') break;
                }

                if (board[nbx][nby] == 'O') continue;
                if (board[nrx][nry] == 'O') return cur.count + 1;

                if (nrx == nbx && nry == nby) {
                    int red_dist = Math.abs(nrx - cur.rx) + Math.abs(nry - cur.ry);
                    int blue_dist = Math.abs(nbx - cur.bx) + Math.abs(nby - cur.by);
                    if (red_dist > blue_dist) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    queue.offer(new State(nrx, nry, nbx, nby, cur.count + 1));
                }
            }
        }

        return -1;
    }
}