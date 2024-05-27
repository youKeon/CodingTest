import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int ans = Integer.MAX_VALUE;
        int rCount = 0;
        int bCount = 0;
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        for (char ball : balls.toCharArray()) {
            if (ball == 'R') {
                rCount++;
            } else {
                bCount++;
            }
        }

        // R을 왼쪽으로
        for (char ball : balls.toCharArray()) {
            if (ball == 'R') {
                count++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, rCount - count);

        count = 0;
        for (char ball : balls.toCharArray()) {
            if (ball == 'B') {
                count++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, bCount - count);

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'R') {
                count++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, rCount - count);

        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'B') {
                count++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, bCount - count);

        System.out.print(ans);
    }
}