import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder writer = new StringBuilder();
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0) {
                if (q.isEmpty()) {
                    writer.append(0).append("\n");
                } else {
                    writer.append(q.poll()).append("\n");
                }
            } else {
                q.add(num);
            }
        }
        System.out.print(writer);
    }
}