import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] names = new String[n];
        int[] powers = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());

            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (powers[mid] < power) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            bw.write(names[left]);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}