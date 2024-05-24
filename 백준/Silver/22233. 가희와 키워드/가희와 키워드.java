import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine(), ", ");
            while (st.hasMoreTokens()) {
                String key = st.nextToken();
                set.remove(key);
            }
            bw.write(String.valueOf(set.size()));
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
