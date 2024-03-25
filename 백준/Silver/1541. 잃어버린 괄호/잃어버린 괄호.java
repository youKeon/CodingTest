import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-"); 
        int ans = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            String[] tmp = arr[i].split("\\+");
            for (int j = 0; j < tmp.length; j++) {
                sum += Integer.parseInt(tmp[j]);
            }
            if(i == 0) {
                ans += sum;
            } else {
                ans -= sum;
            }
        }
        System.out.print(ans);
    }
}
