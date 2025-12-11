//프로그래머스 - 올바른 괄호 (Level 2)
//https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 카운터 방식

package programmers.level_2;

public class CorrectParentheses {
    boolean solution(String s) {
        int count = 0;
        for(char c : s.toCharArray()){
            if( c == '(') count++;
            else {
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
