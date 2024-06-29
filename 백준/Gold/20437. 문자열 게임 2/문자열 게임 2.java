import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            
            if (K == 1) {
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            Map<Character, List<Integer>> charIndices = new HashMap<>();
            for (int i = 0; i < W.length(); i++) {
                char c = W.charAt(i);
                charIndices.putIfAbsent(c, new ArrayList<>());
                charIndices.get(c).add(i);
            }
            
            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            for (Map.Entry<Character, List<Integer>> entry : charIndices.entrySet()) {
                List<Integer> indices = entry.getValue();
                if (indices.size() < K) continue;

                for (int i = 0; i <= indices.size() - K; i++) {
                    int currentLen = indices.get(i + K - 1) - indices.get(i) + 1;
                    minLen = Math.min(minLen, currentLen);
                    maxLen = Math.max(maxLen, currentLen);
                }
            }

            if (minLen == Integer.MAX_VALUE || maxLen == -1) {
                sb.append("-1\n");
            } else {
                sb.append(minLen).append(" ").append(maxLen).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}