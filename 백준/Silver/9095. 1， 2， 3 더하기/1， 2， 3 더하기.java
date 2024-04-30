import java.io.*;

class Main {
    static int n, ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            ans = 0;
            dfs(0, n);
            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    private static void dfs(int total, int l) {
        if (total >= n) {
            if (total == n) {
                ans++;
            }
            return;
        }

        dfs(total + 1, l + 1);
        dfs(total + 2, l + 1);
        dfs(total + 3, l + 1);
    }
}
