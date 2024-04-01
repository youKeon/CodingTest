import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            String[] tmp = arr[i].split("\\+");
            int total = 0;
            for (String s : tmp) {
                total += Integer.parseInt(s);
            }

            if (i == 0) ans += total;
            else ans -= total;
        }
        System.out.println(ans);
    }
}