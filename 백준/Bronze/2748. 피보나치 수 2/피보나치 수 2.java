import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) System.out.print(0);
        else if (n == 1 || n == 2) System.out.print(1);
        else {
            long[] arr = new long[n + 1];
            arr[0] = 0;
            arr[1] = 1;

            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            System.out.print(arr[n]);
        }
    }
}