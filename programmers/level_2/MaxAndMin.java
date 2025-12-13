// 프로그래머스 - 최댓값과 최솟값 (Level 2)
// https://school.programmers.co.kr/learn/courses/30/lessons/12939
// String.split, StringBuilder 사용

package programmers.level_2;

public class MaxAndMin {
    public String solution(String s) {
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        
        String[] numArray = s.split(" ");
        for(String numString : numArray){
            int value = Integer.parseInt(numString);
            
            maxNum = Math.max(maxNum, value);
            minNum = Math.min(minNum, value);
        }
        
        return minNum + " " + maxNum;
    }
}
