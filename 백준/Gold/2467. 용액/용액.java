import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = 0;
        
        while (left < right) {
            int sum = solutions[left] + solutions[right];
            
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                resultLeft = solutions[left];
                resultRight = solutions[right];
            }
            
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        
        System.out.println(resultLeft + " " + resultRight);
    }
}
