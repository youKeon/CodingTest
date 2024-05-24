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

        for (int i = 0; i < count0 / 2; i++) {
            sb.append('0');
        }

        for (int i = 0; i < count1 / 2; i++) {
            sb.append('1');
        }

        System.out.print(sb);
    }
}

/**
 * 0 1로 이뤄진 문자열
 * 0 1의 개수는 짝수
 *
 */
