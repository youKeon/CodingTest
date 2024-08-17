import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char c : str.toCharArray()) left.push(c);
        while (n-- > 0) {
            String[] arr = br.readLine().split(" ");
            switch (arr[0]) {
                case "L" -> {
                    if (!left.isEmpty()) right.push(left.pop());
                }
                case "D" -> {
                    if (!right.isEmpty()) left.push(right.pop());
                }
                case "B" -> {
                    if (!left.isEmpty()) left.pop();
                }
                case "P" -> {
                    left.push(arr[1].charAt(0));
                }
            }
        }
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.print(sb);
    }
}