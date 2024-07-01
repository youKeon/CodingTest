import java.time.*;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> ioMap = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();
        Map<String, Long> timeMap = new HashMap<>();

        int dMin = fees[0];
        int dFee = fees[1];
        int pMin = fees[2];
        int pFee = fees[3];

        for (String s : records) {
            String[] arr = s.split(" ");

            String time = arr[0];
            String carNumber = arr[1];
            String io = arr[2];

            if (io.equals("OUT")) {
                String inTime = ioMap.get(carNumber);
                LocalTime from = LocalTime.parse(inTime);
                LocalTime to = LocalTime.parse(time);

                long duration = Duration.between(from, to).toMinutes();

                timeMap.put(carNumber, timeMap.getOrDefault(carNumber, (long) 0) + duration);

                ioMap.remove(carNumber);
            } else {
                ioMap.put(carNumber, time);
            }
        }

        if (!ioMap.isEmpty()) {
            for (String carNumber : ioMap.keySet()) {
                String tmp = ioMap.get(carNumber);
                LocalTime from = LocalTime.parse(tmp);
                LocalTime to = LocalTime.parse("23:59");

                long duration = Duration.between(from, to).toMinutes();

                timeMap.put(carNumber, timeMap.getOrDefault(carNumber, (long) 0) + duration);

            }
        }

        for (String carNumber : timeMap.keySet()) {
            long duration = timeMap.get(carNumber);

            if (duration > dMin) {
                int fee = dFee;
                duration -= dMin;
                double tmp = (double) duration / pMin;
                duration = (int) Math.ceil(tmp);
                fee += duration * pFee;

                feeMap.put(carNumber, feeMap.getOrDefault(carNumber, 0) + fee);
            } else {
                feeMap.put(carNumber, feeMap.getOrDefault(carNumber, 0) + dFee);
            }
        }
        List<String> list = new ArrayList<>(feeMap.keySet());
        list.sort(Comparator.naturalOrder());

        List<Integer> ans = new ArrayList<>();

        for (String s : list) {
            ans.add(feeMap.get(s));
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}

// fees[0] = 기본 시간
// fees[1] = 기본 요금
// fees[2] = 단위 시간
// fees[3] = 단위 요금