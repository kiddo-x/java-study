// 프로그래머스 - 개인정보 수집 유효기간 (Lv1)
// https://school.programmers.co.kr/learn/courses/30/lessons/150370
// HashMap + 날짜 변환 방식 풀이

import java.util.*;

public class Problem_개인정보수집유효기간 {

    public int convertDate(String s){
        int date = Integer.parseInt(s.substring(2,4))*28*12;
        date += Integer.parseInt(s.substring(5,7))*28;
        date += Integer.parseInt(s.substring(8,10));
        return date;
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<Character, Integer> termsMap = new HashMap<>();
        for(String term : terms){
            int t = Integer.parseInt(term.substring(2))*28;
            termsMap.put(term.charAt(0), t);
        }
        
        List<Integer> answerList = new ArrayList<>();
        int i = 1;
        for(String privacy : privacies){
            if(convertDate(today) >= 
               convertDate(privacy) + termsMap.get(privacy.charAt(11))){
               answerList.add(i); 
            }
            i++;
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
