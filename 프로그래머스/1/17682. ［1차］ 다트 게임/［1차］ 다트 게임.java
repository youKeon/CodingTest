class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3]; // 각 기회에서 얻은 점수 저장
        int index = -1; // 현재 기회의 인덱스
        int length = dartResult.length();

        for (int i = 0; i < length; i++) {
            char ch = dartResult.charAt(i);

            if (Character.isDigit(ch)) {
                index++; // 새 기회 시작
                // 숫자가 연속되는 경우(10 처리)
                if (ch == '1' && i + 1 < length && dartResult.charAt(i + 1) == '0') {
                    scores[index] = 10;
                    i++;
                } else {
                    scores[index] = ch - '0';
                }
            } else if (ch == 'S') {
                // Single: 점수 그대로
                scores[index] = (int) Math.pow(scores[index], 1);
            } else if (ch == 'D') {
                // Double: 점수의 2제곱
                scores[index] = (int) Math.pow(scores[index], 2);
            } else if (ch == 'T') {
                // Triple: 점수의 3제곱
                scores[index] = (int) Math.pow(scores[index], 3);
            } else if (ch == '*') {
                // 스타상: 현재 점수와 이전 점수를 2배
                if (index > 0) {
                    scores[index - 1] *= 2;
                }
                scores[index] *= 2;
            } else if (ch == '#') {
                // 아차상: 현재 점수를 마이너스로
                scores[index] *= -1;
            }
        }

        // 최종 점수 합산
        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }

        return totalScore;
    }
}