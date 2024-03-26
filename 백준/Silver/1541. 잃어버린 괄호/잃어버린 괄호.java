import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int ans = 0;
        int sum = 0;
        String[] arr = br.readLine().split("-");
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            String[] split = arr[i].split("\\+");
            for (String s : split) {
                sum += Integer.parseInt(s);
            }

            if (i == 0) ans += sum;
            else ans -= sum;
        }
        System.out.print(ans);
    }
}
