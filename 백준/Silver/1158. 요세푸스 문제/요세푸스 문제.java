import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) q.add(i);

        ans.append("<");
        while (!q.isEmpty()) {
            for (int i = 0; i < m - 1; i++) q.add(q.poll());
            if (q.size() == 1) ans.append(q.poll());
            else ans.append(q.poll()).append(", ");
        }
        ans.append(">");
        System.out.print(ans);
    }
}
