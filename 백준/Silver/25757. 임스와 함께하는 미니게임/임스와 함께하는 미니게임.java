import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Set<String> set = new HashSet<>();
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int needCount = game.equals("Y") ? 1 : game.equals("F") ? 2 : 3;
        int count = 0;

        for (int i = 0; i < n; i++) {
            String member = br.readLine();
            if (!set.contains(member)) {
                count++;
                set.add(member);
                if (count == needCount) {
                    ans++;
                    count = 0;
                }
            }
        }
        System.out.print(ans);
    }
}
