import java.io.*;
import java.util.*;

class Main {
    public static int white = 0;
    public static int blue = 0;
    public static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, N);
        System.out.println(white);
        System.out.print(blue);
    }

    public static void partition(int row, int col, int size) {
        if(isSameColor(row, col, size)) {
            if(board[row][col] == 0) white++;
            else blue++;
            return;
        }

        int nextSize = size / 2;	
        partition(row, col, nextSize);						
        partition(row, col + nextSize, nextSize);		
        partition(row + nextSize, col, nextSize);		
        partition(row + nextSize, col + nextSize, nextSize);	
    }

    public static boolean isSameColor(int row, int col, int size) {
        int color = board[row][col];	
        
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
