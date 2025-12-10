// 프로그래머스 완주하지 못한 선수 (Lv1)
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
// HashMap 사용 풀이

import java.util.HashMap;
import java.util.Map;

public class IncompleteParticipant {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String p : participant)
            map.put(p, map.getOrDefault(p, 0) + 1);
        
        for(String p : completion)
            map.put(p, map.get(p) - 1);
        
        for(Map.Entry<String, Integer> entry : map.entrySet())
            if(entry.getValue() != 0) 
                return entry.getKey();
        
        return "";
    }
}
