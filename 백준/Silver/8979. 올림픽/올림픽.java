import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 국가 수
        int K = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            arr[country - 1][0] = Integer.parseInt(st.nextToken());
            arr[country - 1][1] = Integer.parseInt(st.nextToken());
            arr[country - 1][2] = Integer.parseInt(st.nextToken());
        }
        int[] target = arr[K - 1];

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return o2[2] - o1[2];
                } else return o2[1] - o1[1];
            } else return o2[0] - o1[0];
        });

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Arrays.equals(arr[i], target)) {
                ans = i + 1;
                break;
            }
        }
        System.out.print(ans);
    }
}