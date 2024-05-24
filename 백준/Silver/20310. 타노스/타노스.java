import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        count0 /= 2;
        count1 /= 2;
        int p0 = 0;
        int p1 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                if (count1 != 0) {
                    count1--;
                    arr[i] = '-';
                }
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                if (count0 != 0) {
                    count0--;
                    arr[i] = '-';
                }
            }
        }

        for (char c : arr) {
            if (c != '-') {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}

/**
 * 0 1로 이뤄진 문자열
 * 0 1의 개수는 짝수
 *
 */
