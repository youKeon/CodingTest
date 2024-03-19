import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                boolean start = check(startX, startY, x, y, r);
                boolean end = check(endX, endY, x, y, r);
                if (start != end) ans++;
            }
            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    private static boolean check(int startX, int startY, int x, int y, int r) {
        int distance = (startX - x) * (startX - x) + (startY - y) * (startY - y);
        return r * r >= distance;
    }


}
