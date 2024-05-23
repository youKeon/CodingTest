import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] word = new int[26];

        String og = br.readLine();
        for (int i = 0; i < og.length(); i++) {
            word[og.charAt(i) - 'A']++;
        }

        for (int i = 0; i < n - 1; i++) {
            int[] copy = word.clone();
            int count = 0;
            String comp = br.readLine();

            for (int j = 0; j < comp.length(); j++) {
                if (copy[comp.charAt(j) - 'A'] > 0) {
                    copy[comp.charAt(j) - 'A']--;
                    count++;
                }
            }

            if (og.length() == comp.length()) {
                if (count == og.length() || count == og.length() - 1) {
                    ans++;
                }
            } else if (og.length() - 1 == comp.length() && count == comp.length()) {
                ans++;
            } else if (og.length() + 1 == comp.length() && count == comp.length() - 1) {
                ans++;
            }
        }
        System.out.print(ans);
    }
}