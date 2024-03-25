import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int end = Integer.MIN_VALUE;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            end = Math.max(arr[i][1], end);
        }

        Arrays.sort(arr, (arr1, arr2) -> {
            if (arr1[1] == arr2[1]) return arr1[0] - arr2[0];
            return arr1[1] - arr2[1];
        });
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= cur) {
                cur = arr[i][1];
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
}
