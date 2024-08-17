import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sortedArr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);

        int index = 0;
        map.put(sortedArr[0], index++);
        for (int i = 1; i < n; i++) {
            if (sortedArr[i - 1] == sortedArr[i]) {
                map.put(sortedArr[i], map.get(sortedArr[i - 1]));
            } else {
                map.put(sortedArr[i], index++);
            }
        }
        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.print(sb);
    }
}