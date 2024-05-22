import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int pointer = 0;
        int ans = 0;

        for (int i = 1; i <= 30000 ; i++) {
            String target = String.valueOf(i);
            for (int j = 0; j < target.length(); j++) {
                if (target.charAt(j) == number.charAt(pointer)) {
                    pointer++;

                    if (pointer == number.length()) {
                        ans = i;
                        break;
                    }
                }
            }
            if (ans != 0) break;
        }
        System.out.println(ans);

    }
}

/**
 * 1부터 N까지 적음
 * 몇 개의 숫자를 지움
 * N이 기억이 안남
 * 남은 수를 
 */
