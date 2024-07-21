import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        while (n != 0) {
            if (n % 5 == 0) {
                ans = n / 5 + ans;
                break;
            } else if (n < 0) {
                ans = -1;
                break;
            }
            ans++;
            n -= 3;
        }
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
}