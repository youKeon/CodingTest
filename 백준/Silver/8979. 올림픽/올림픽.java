import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 국가 수
        int K = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            map.put(country, (gold * 3) + (silver * 2) + bronze);
        }

        int ans = 1;
        int target = map.get(K);
        for (Integer i : map.keySet()) {
            if (map.get(i) > target) ans++;
        }

        System.out.print(ans);
    }
}