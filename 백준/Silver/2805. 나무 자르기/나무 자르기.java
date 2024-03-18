import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long count = 0;
            for (int i : arr) if (mid < i) count += i - mid;

            if (count < m) max = mid;
            else min = mid + 1;
        }
        System.out.println(min - 1);
    }
}