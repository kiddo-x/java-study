// 프로그래머스 - 신고 결과 받기 (Lv1)
// https://school.programmers.co.kr/learn/courses/30/lessons/92334
// HashMap + Set 사용 풀이

import java.util.*;
public class ReportResult {
    
    public int[] solution(String[] id_list, String[] report, int k) {
    	//key - 신고자아이디, value - 신고한아이디
        Map<String, Set<String>> reportList = new HashMap<>();
        
        //key - 아이디, value - 신고 당한 횟수
        Map<String, Integer> reportCount = new HashMap<>();
        
        for(String id : id_list)
            reportList.put(id, new HashSet<>());
        
        //신고자별 신고한 아이디 repotList에 저장(중복x)
        for(String str : report){
            String[] id = str.split(" ");
            reportList.get(id[0]).add(id[1]);
        }
        
        //repotList 보고 신고 당한 횟수 reportCount에 저장 
        for(String reporter : reportList.keySet()){
            for(String reportedId : reportList.get(reporter)){
                reportCount.put(reportedId, reportCount.getOrDefault(reportedId, 0) + 1);
            }
        }
        
        //reportCount보고 k이상이면 banned_id set에 넣는다.
        Set<String> banned_id = new HashSet<>();
        for(String id : reportCount.keySet())
            if(reportCount.get(id) >= k) banned_id.add(id);
        
        //reportList로 돌아와 신고한 아이디가 banned_id에 포함되어 있으면 정지메일+1
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            for(String reportedId : reportList.get(id_list[i])){
                if(banned_id.contains(reportedId)) answer[i]++;
            }
        }
        
        return answer;
    }
}