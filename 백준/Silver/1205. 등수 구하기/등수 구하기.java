import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); 
        int newScore = scanner.nextInt();
        int P = scanner.nextInt(); 

        int[] scores = new int[N]; 
        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }

        int rank = 1;

        if (N < P || (N == P && scores[N - 1] < newScore)) {
            while (rank <= N && scores[rank - 1] > newScore) {
                rank++;
            }
        } else {
            rank = -1;
        }
        System.out.print(rank);
    }
}

