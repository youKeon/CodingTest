import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int li = 0;
        int ri = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int[] ansArr = new int[2];

        while (li < ri) {
            int total = arr[li] + arr[ri];
            int abs = Math.abs(total);

            if (ans > abs) {
                ans = abs;
                ansArr[0] = arr[li];
                ansArr[1] = arr[ri];
            }

            if (total > 0) ri--;
            else li++;
        }
        system.out.print(ansArr[0] + " " + ansArr[1]);
    }
}
