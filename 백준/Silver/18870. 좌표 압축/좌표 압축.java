import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> map = new HashMap();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] tmp = arr.clone();

        Arrays.sort(tmp);

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(tmp[i]))
                map.put(tmp[i], cnt++);
        }
        for (int i = 0; i < n; i++) {
            bw.write(map.get(arr[i]) + " ");
        }
        bw.close();
        br.close();
    }
}