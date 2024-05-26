import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> ans = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i >= 1; i--) {
            ans.add(arr[i], i);
        }

        for (Integer i : ans) {
            bw.write(i + " ");
        }
        bw.close();
        br.close();
    }
}
