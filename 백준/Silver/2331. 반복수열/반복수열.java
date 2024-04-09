import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ans = 0;
        list.add(A);

        while (true) {
            Integer cur = list.get(list.size() - 1);
            int tmp = operation(cur, P);

            if (list.contains(tmp)) {
                ans = list.indexOf(tmp);
                break;
            }

            list.add(tmp);
        }
        System.out.print(ans);
    }

    private static int operation(Integer cur, int p) {
        int result = 0;
        while (cur != 0) {
            int tmp = cur % 10;
            result += Math.pow(tmp, p);
            cur /= 10;
        }
        return result;
    }
}
