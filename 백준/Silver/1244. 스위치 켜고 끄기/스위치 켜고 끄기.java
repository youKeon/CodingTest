import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                opM(switches, index);
            } else {
                opW(switches, index);
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(switches[i] + " ");
            if (i % 20 == 0) bw.newLine();
        }
        bw.close();
        br.close();
    }

    private static void opM(int[] switches, int index) {
        for (int i = 1; i <= switches.length - 1; i++) {
            if (i % index == 0) {
                switches[i] = switches[i] == 0 ? 1 : 0;
            }
        }
    }

    private static void opW(int[] switches, int index) {
        int start = index - 1;
        int end = index + 1;

        while (start >= 1 && end <= switches.length - 1) {
            if (switches[start] != switches[end]) {
                break;
            }
            start--;
            end++;
        }
        start++;
        end--;

        for (int i = start; i <= end; i++) {
            switches[i] = switches[i] == 0 ? 1 : 0;
        }
    }
}

/**
 * 남 1
 * 여 2
 */

/**
 * 입력
 * 8 스위치 개수
 * 0 1 0 1 0 0 0 1 스위치 상태
 * 2 학생 수
 * 1 3 성별 스위치 번호
 * 2 3
 */