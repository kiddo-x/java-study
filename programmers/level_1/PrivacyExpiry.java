// 프로그래머스 - 개인정보 수집 유효기간 (Lv1)
// https://school.programmers.co.kr/learn/courses/30/lessons/150370
// HashMap + 날짜 변환 방식 풀이

import java.util.*;

public class PrivacyExpiry {
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]) * 28);
        }

        int todayDays = convertToDays(today);
        List<Integer> expiredIndexes = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            String date = parts[0];
            String termType = parts[1];

            int privacyDays = convertToDays(date) + termMap.get(termType);
            if (privacyDays <= todayDays) {
                expiredIndexes.add(i + 1);
            }
        }

        return expiredIndexes.stream().mapToInt(i -> i).toArray();
    }

    private int convertToDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return year * 12 * 28 + month * 28 + day;
    }
}
