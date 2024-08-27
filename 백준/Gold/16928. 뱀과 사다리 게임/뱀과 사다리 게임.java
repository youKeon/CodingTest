import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] board = new int[101];
        boolean[] visited = new boolean[101];
        
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); 
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int count = current[1];
            
            if (position == 100) {
                System.out.println(count);
                return;
            }
            
            for (int i = 1; i <= 6; i++) {
                int next = position + i;
                if (next > 100) continue;
                
                if (board[next] != 0) {
                    next = board[next];
                }
                
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, count + 1});
                }
            }
        }
    }
}