import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] distance = new long[n - 1];
        long[] cost = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distance.length; i++) distance[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cost.length; i++) cost[i] = Long.parseLong(st.nextToken());

        long ans = 0;
        long min = cost[0];
        for (int i = 0; i < n - 1; i++) {
            if (cost[i] < min) min = cost[i];
            ans += min * distance[i];
        }

        System.out.println(ans);
    }
}

/**
 * 현재 도시의 기름 가격 >= 다음 도시의 기름 가격
 * 다음 도시로 갈만큼만 충전
 *
 * 현재 도시의 기름 가격 < 다음 도시의 기름 가격
 * 현재 도시의 기름 가격보다 저렴한 도시를 갈만큼만 충전
 */