import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            if ((i + 1) % 3 != 0) {
                ans += list.get(i);
            }
        }
        System.out.print(ans);
    }
}
