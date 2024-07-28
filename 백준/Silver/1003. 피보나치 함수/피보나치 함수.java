import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int[] zeroCount = new int[41];
        int[] oneCount = new int[41];

        zeroCount[0] = 1;
        zeroCount[1] = 0;
        oneCount[0] = 0;
        oneCount[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zeroCount[i] = zeroCount[i-1] + zeroCount[i-2];
            oneCount[i] = oneCount[i-1] + oneCount[i-2];
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(zeroCount[N]).append(" ").append(oneCount[N]).append("\n");
        }

        System.out.print(sb);
    }
}
