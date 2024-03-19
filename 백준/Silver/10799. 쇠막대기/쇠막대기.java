import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (stack.isEmpty()) stack.push(cur);
            else {
                // 현재 문자가 '('인 경우 스택에 저장
                if (cur == '(') stack.push(cur);

                // 현재 문자가 ')'인 경우
                else {

                    // 이전 문자가 '('였으면 스택 크기만큼 더하기
                    if (str.charAt(i - 1) == '(') {
                        stack.pop();
                        ans += stack.size();
                    }

                    // 이전 문자가 ')'였으면 +1
                    else {
                        stack.pop();
                        ans++;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
