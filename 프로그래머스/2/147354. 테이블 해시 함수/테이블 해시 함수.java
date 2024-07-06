import java.util.*;

public class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // Step 1: 테이블 정렬
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                return Integer.compare(b[0], a[0]);
            } else {
                return Integer.compare(a[col - 1], b[col - 1]);
            }
        });

        // Step 2: S_i 계산 및 해시 값 계산
        int hashValue = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int S_i = 0;
            for (int val : data[i]) {
                S_i += val % (i + 1);
            }
            hashValue ^= S_i;
        }

        return hashValue;
    }
}
