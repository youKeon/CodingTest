import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        String[][] arr = new String[files.length][3];
        String[] ans = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            String cur = files[i];

            int start = 0;
            int end = 0;

            for (int j = 0; j < cur.length(); j++) {
                if (Character.isDigit(cur.charAt(j))) {
                    start = j;
                    while (j < cur.length() && Character.isDigit(cur.charAt(j))) {
                        j++;
                    }
                    end = j;
                    break;
                }
            }

            arr[i][0] = cur.substring(0, start);
            arr[i][1] = cur.substring(start, end);
            arr[i][2] = cur.substring(end);
        }

        Arrays.sort(arr, (o1, o2) -> {
            String head1 = o1[0].toLowerCase();
            String head2 = o2[0].toLowerCase();

            int num1 = Integer.parseInt(o1[1]);
            int num2 = Integer.parseInt(o2[1]);

            if (head1.equals(head2)) {
                if (num1 == num2) return 0;
                else return num1 - num2;
            } else {
                return head1.compareTo(head2);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            String[] s = arr[i];
            ans[i] = String.join("", s);
        }

        return ans;
    }
}

// HEAD : 문자, 한 글자 이상
// NUMBER : 1~5글자
// TAIL : 나머지

// 문자열을 문자의 배열로 변환
// 문자 배열을 순회
// 숫자가 나오면 다음 문자가 나오기 전까지 카운팅
// 숫자 영역이 NUMBER
// 그 앞이 HEAD
// 그 뒤가 TAIL