// 프로그래머스 - 여행경로 (level 3)
// https://school.programmers.co.kr/learn/courses/30/lessons/43164
// 완전탐색, DFS

package programmers.level_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelPath {
    
    String[][] tickets;
    boolean[] visited;
    List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", path, 0);
       
        return answer.stream()
            .toArray(String[]::new);
    }
    
    private boolean dfs(String dest, List<String> path, int index){
        if(index == tickets.length) {
            // 최적 경로 찾으면 반환
            answer = new ArrayList<>(path);
            return true;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(dest)){
                visited[i] = true;
                path.add(tickets[i][1]);
                if(dfs(tickets[i][1], path, index+1)) return true;
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
        
        return false;
    }
}
