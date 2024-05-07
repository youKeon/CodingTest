import java.util.*;
import java.io.*;

class Main {
    static Set<Integer> set = new HashSet<>(); // 고장난 버튼을 저장할 Set
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); 
        int M = scanner.nextInt(); 


        for (int i = 0; i < M; i++) {
            set.add(scanner.nextInt());
        }

        int min = Math.abs(N - 100);

        for (int i = 0; i <= 1000000; i++) {
            if (isPossible(i)) {
                min = Math.min(min, Math.abs(N - i) + String.valueOf(i).length());
            }
        }
        System.out.println(min);
    }

    private static boolean isPossible(int channel) {
        for (char digit : String.valueOf(channel).toCharArray()) {
            if (set.contains(digit - '0')) {
                return false;
            }
        }
        return true;
    }
}
