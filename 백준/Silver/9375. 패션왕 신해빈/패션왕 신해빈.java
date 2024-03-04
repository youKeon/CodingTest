import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int ans = 1;
            int n = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String key = st.nextToken();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            
            for (Integer value : map.values()) ans *= value + 1;
            System.out.println(ans - 1);
            map.clear();
        }
    }
}
