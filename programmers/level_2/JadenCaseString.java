//프로그래머스 - JadenCase 문자열 만들기 (Level 2)
//https://school.programmers.co.kr/learn/courses/30/lessons/12951
// StringBuilder 사용, Character.isLetter, Character.toUpperCase, Character.toLowerCase 이용

package programmers.level_2;

public class JadenCaseString {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (i == 0 || s.charAt(i - 1) == ' ') {   // 단어의 첫 글자
                if (Character.isLetter(c)) 
                    answer.append(Character.toUpperCase(c));

                else answer.append(c); // 숫자 등
            } 
            else answer.append(Character.toLowerCase(c));
        }
        return answer.toString();
    }
}
