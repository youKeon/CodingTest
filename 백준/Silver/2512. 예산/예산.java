import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        int left = 0;
        int right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int budget = Integer.parseInt(br.readLine());

        int mid = 0;
        int ans = 0;

        while (left <= right) {
            mid = (left + right) / 2;
             if (isAble(mid, budget)) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isAble(int mid, int budget) {
        int total = 0;
        for (int i : arr) {
            if (i <= mid) {
                total += i;
            } else {
                total += mid;
            }
        }

        return total <= budget;
    }
}