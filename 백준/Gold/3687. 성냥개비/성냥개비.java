import java.io.*;
import java.util.*;
 
public class Main {
    static long [] dp;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[]{1,7,4,2,0,8};
        int t = Integer.parseInt(br.readLine());
 
        dp = new long[101];
 
        Arrays.fill(dp,Long.MAX_VALUE);
 
        dp[2]=1;
        dp[3]=7;
        dp[4]=4;
        dp[5]=2;
        dp[6]=6;
        dp[7]=8;
        dp[8]=10;
 
        StringBuilder sb;
 
 
        for(int i=9; i<=100; i++){
            for(int j=2; j<=7; j++){
                String temp = String.valueOf(dp[i-j])+String.valueOf(arr[j-2]);
                dp[i] = Math.min(Long.parseLong(temp),dp[i]);
            }
        }
 
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
 
            sb.append(dp[n]).append(" ");
            if(n%2==0){
                sb.append(convertMax(n/2));
            }
            else{
                sb.append("7").append(convertMax((n-3)/2));
            }
 
            System.out.println(sb.toString());
        }
    }
 
    private static String convertMax(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append("1");
        }
        return sb.toString();
    }
}