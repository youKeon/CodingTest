import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean findAns = false;
            int ans = Integer.MAX_VALUE;
            String[] arr = new String[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken();
            }

            for (int i = 0; i < n - 2; i++) {
                if (findAns) break;
                for (int j = i + 1; j < n - 1; j++) {
                    if (findAns) break;
                    for (int k = j + 1; k < n; k++) {
                        String p1 = arr[i];
                        String p2 = arr[j];
                        String p3 = arr[k];

                        int result = calc(p1, p2, p3);
                        if (result == 0) {
                            findAns = true;
                            ans = 0;
                            break;
                        }
                        ans = Math.min(ans, result);
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static int calc(String p1, String p2, String p3) {
        int result = 0;

        for (int i = 0; i < 4; i++) {
            char tmp1 = p1.charAt(i);
            char tmp2 = p2.charAt(i);

            if (tmp1 != tmp2) result++;
        }

        for (int i = 0; i < 4; i++) {
            char tmp2 = p2.charAt(i);
            char tmp3 = p3.charAt(i);

            if (tmp2 != tmp3) result++;
        }

        for (int i = 0; i < 4; i++) {
            char tmp1 = p1.charAt(i);
            char tmp3 = p3.charAt(i);

            if (tmp1 != tmp3) result++;
        }

        return result;
    }
}