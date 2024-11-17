import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];

        int[] dx = {0, 1, -1}; 
        int[] dy = {1, 0, -1}; 

        int y = 0, x = 0; 
        int num = 1;      
        int direction = 0;

        for (int i = 0; i < n * (n + 1) / 2; i++) {
            triangle[y][x] = num++;
            int ny = y + dy[direction];
            int nx = x + dx[direction];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n || triangle[ny][nx] != 0) {
                direction = (direction + 1) % 3;
                ny = y + dy[direction];
                nx = x + dx[direction];
            }
            y = ny;
            x = nx;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result.add(triangle[i][j]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}