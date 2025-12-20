// 프로그래머스 - Level 3 - 불량 사용자
// https://school.programmers.co.kr/learn/courses/30/lessons/64064
// DFS와 Set을 활용한 조합 문제

package programmers.level_3;

import java.util.HashSet;
import java.util.Set;

public class BadUser {
    
    Set<Set<String>> idSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(new HashSet<>(), 0, user_id, banned_id);
        
        return idSet.size();
    }
    
    void dfs(Set<String> set, int index, String[] user_id, String[] banned_id) {
        if (index == banned_id.length) {
            idSet.add(new HashSet<>(set));
            return;
        }
        
        for (String id : user_id) {
            if (set.contains(id)) continue;
            if (check(id, banned_id[index])) {
                set.add(id);
                dfs(set, index+1, user_id, banned_id);
                set.remove(id);
            }
        }
    }
    
    boolean check(String a, String b) {
        if(a.length() != b.length()) return false;
        
        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '*') continue;
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
}