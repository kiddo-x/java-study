// 프로그래머스 - 최댓값과 최솟값 (Level 2)
// https://school.programmers.co.kr/learn/courses/30/lessons/12939
// String.split, StringBuilder 사용

package programmers.level_2;

public class MaxAndMin {
        public String solution(String s) {
        int maxNum = -999999999;
        int minNum = 999999999;
        
        String[] numArray = s.split(" ");
        for(String numString : numArray){
            maxNum = Math.max(maxNum, Integer.parseInt(numString));
            minNum = Math.min(minNum, Integer.parseInt(numString));
        }
        
        StringBuilder answer = new StringBuilder();
        return answer
            .append(String.valueOf(minNum))
            .append(" ")
            .append(String.valueOf(maxNum))
            .toString();
    }
}
