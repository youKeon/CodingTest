import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int fromX = Integer.parseInt(st.nextToken());
            int fromY = Integer.parseInt(st.nextToken());
            int toX = Integer.parseInt(st.nextToken());
            int toY = Integer.parseInt(st.nextToken());

            int ans = 0;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean result1 = isIncluded(fromX, fromY, cx, cy, r);
                boolean result2 = isIncluded(toX, toY, cx, cy, r);
                if (result1 != result2) ans++;
            }
            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    private static boolean isIncluded(int x, int y, int cx, int cy, int r) {
        int dis = (x - cx) * (x - cx) + (y - cy) * (y - cy);
        return dis <= r * r;
    }
}
