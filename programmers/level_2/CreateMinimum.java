//프로그래머스 - 최솟값 만들기 (Level 2)
//https://school.programmers.co.kr/learn/courses/30/lessons/12941
// Arrays.sort 이용
// 그리디 알고리즘

package programmers.level_2;

import java.util.Arrays;

public class CreateMinimum {
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        for(int i=0; i<A.length; i++){
            answer += A[i] * B[B.length-1-i];
        }
        return answer;
    }
}
