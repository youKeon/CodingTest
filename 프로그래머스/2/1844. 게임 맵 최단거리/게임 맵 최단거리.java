import java.util.*;

class Solution {
    int[][] map;
    int[][] isVisited;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    
    static class Pos {
        int y;
        int x;
        
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(int[][] maps) {
        this.map = maps;
        this.isVisited = new int[map.length][map[0].length];
        for (int[] i : isVisited) {
            Arrays.fill(i, -1);
        }
        
        bfs();
        
        return isVisited[maps.length - 1][maps[0].length - 1];
    }
    
    private void bfs() {
        Deque<Pos> dq = new ArrayDeque<>();
        dq.add(new Pos(0, 0));
        isVisited[0][0] = 1;
        
        while(!dq.isEmpty()) {
            Pos cur = dq.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                
                if (ny >= 0 && ny < map.length &&
                    nx >= 0 && nx < map[0].length &&
                    isVisited[ny][nx] == -1 && map[ny][nx] == 1) {
                    dq.addLast(new Pos(ny, nx));
                    isVisited[ny][nx] = isVisited[cur.y][cur.x] + 1;
                }
            }
        }
    }
}