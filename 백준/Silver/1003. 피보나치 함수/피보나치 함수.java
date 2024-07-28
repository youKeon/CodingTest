import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] zero_count = new int[41];
        int[] one_count = new int[41];

        zero_count[0] = 1;
        one_count[0] = 0;
        zero_count[1] = 0;
        one_count[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zero_count[i] = zero_count[i-1] + zero_count[i-2];
            one_count[i] = one_count[i-1] + one_count[i-2];
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(zero_count[N]).append(" ").append(one_count[N]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
