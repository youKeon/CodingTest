import java.util.*;

class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int len = phone_number.length();
        int starCount = len - 4;
        
        for (int i = 0; i < starCount; i++) {
            sb.append("*");
        }
        
        sb.append(phone_number.substring(starCount, phone_number.length()));
        System.out.println(sb);
        return sb.toString();
    }
}