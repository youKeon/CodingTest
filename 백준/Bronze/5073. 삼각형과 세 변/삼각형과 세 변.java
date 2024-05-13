import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        while (true) {
            String tmp = br.readLine();
            if (tmp.equals("0 0 0")) break;

            String[] string = tmp.split(" ");
            int[] arr = new int[string.length];
            arr[0] = Integer.parseInt(string[0]);
            arr[1] = Integer.parseInt(string[1]);
            arr[2] = Integer.parseInt(string[2]);
            Arrays.sort(arr);

            int count = 1;
            if (arr[2] >= arr[0] + arr[1]) {
                bw.write("Invalid");
                bw.newLine();
                continue;
            } else {
                for (int i = 1; i < 3; i++) {
                    if (arr[i] == arr[i - 1]) {
                        count++;
                    }
                }
            }
            if (count == 3) {
                bw.write("Equilateral");
            } else if (count == 2) {
                bw.write("Isosceles");
            } else {
                bw.write("Scalene");
            }
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}

/**
 * e : 3
 * i : 2
 * s : 0
 */
