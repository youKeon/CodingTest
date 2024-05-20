import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int testNumber = Integer.parseInt(st.nextToken());
            int count = 0;
            int[] arr = new int[20];

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 20; i++) {
                for (int j = i; j >= 0; j--) {
                    if (arr[i] < arr[j]) {
                        count++;
                    }
                }
            }
            bw.write(testNumber + " " + count);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}