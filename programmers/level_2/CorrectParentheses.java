//프로그래머스 - 올바른 괄호 (Level 2)
//https://school.programmers.co.kr/learn/courses/30/lessons/12909
// Queue 사용

package programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class CorrectParentheses {
        boolean solution(String s) {
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') q.offer(c);
            else if(q.isEmpty()) return false;
            else q.poll();
        }
        if(q.isEmpty()) return true;
        else return false;
    }
}
