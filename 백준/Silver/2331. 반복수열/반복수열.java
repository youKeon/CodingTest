import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ans = 0;

        List<Integer> list = new ArrayList<>();
        list.add(A);

        while (true) {
            Integer cur = list.get(list.size() - 1);
            int sum = 0;
            while (cur > 0) {
                int remain = cur % 10;
                sum += Math.pow(remain, P);
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
