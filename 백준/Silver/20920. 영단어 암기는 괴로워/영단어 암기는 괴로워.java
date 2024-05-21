import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> count = new HashMap<>();
        List<String> wordList = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken()); // 단어 개수
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                if (count.containsKey(word)) {
                    count.put(word, count.get(word) + 1);
                } else {
                    count.put(word, 0);
                    wordList.add(word);
                }
            }
        }

        wordList.sort((o1, o2) -> {
            if (count.get(o1) == count.get(o2)) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o2.length() - o1.length();
                }
            } else {
                return count.get(o2) - count.get(o1);
            }
        });

        for (String word : wordList) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}

/**
 * 자주 나오는 단어는 앞으로
 * 길수록 앞으로
 * 사전 순으로 앞으로
 * M 이상의 길이의 단어만 암기
 */