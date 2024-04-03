import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int ans = 0;

        list.add(n);
        while (true) {
            Integer cur = list.get(list.size() - 1);

            int sum = 0;
            while (cur != 0) {
                sum += Math.pow(cur % 10, p);
                cur /= 10;
            }

            if (list.contains(sum)) {
                ans = list.indexOf(sum);
                break;
            }
            list.add(sum);
        }
        
        System.out.print(ans);
    }
}
