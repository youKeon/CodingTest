import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int index = 0;
        long num = 1;
        if (str.equals("0")) {
            System.out.println(10);
        } else {
            while (index < str.length()) {
                String s = String.valueOf(num);
                if (s.contains(String.valueOf(str.charAt(index)))) {
                    int p = 0;
                    while (index < str.length() && p < s.length()) {
                        if (str.charAt(index) == s.charAt(p)) index++;
                        p++;
                    }
                }
                num++;
            }
            System.out.println(num - 1);
        }
    }
}