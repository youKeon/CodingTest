import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String tmp = br.readLine();
        int ans = 0;
        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            arr[i] = tmp.charAt(i);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P' && canEat(arr, i, k)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean canEat(char[] arr, int i, int k) {
        int start = Math.max(i - k, 0);
        int end = Math.min(i + k, arr.length - 1);
        for (int j = start; j <= end; j++) {
            if (arr[j] == 'H') {
                arr[j] = '-';
                return true;
            }
        }
        return false;
    }
}

/**
 * K 거리 이하인 햄버거만 먹을 수 있음
 * 자신보다 최대한 멀리 있는 햄버거를 먹자
 *
 * 사람 : 1
 * 햄버거 : 0
 */