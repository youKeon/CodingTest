import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        String[] arr = br.readLine().split("");
        int m = Integer.parseInt(br.readLine());

        for(String s : arr) {
            left.push(s);
        }

        for(int i = 0; i < m; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch(c) {
                case 'L':
                    if(!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;

                case 'D':
                    if(!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;

                case 'B':
                    if(!left.isEmpty()) {
                        left.pop();
                    }
                    break;

                case 'P':
                    char t = command.charAt(2);
                    left.push(String.valueOf(t));
                    break;
            }
        }

        while(!left.isEmpty()) right.push(left.pop());
        while(!right.isEmpty()) bw.write(right.pop());

        bw.close();
        bw.close();
    }
}