// 프로그래머스 Level 2 - 숫자의 표현
// https://school.programmers.co.kr/learn/courses/30/lessons/12924
// Queue를 이용한 풀이

package programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;



public class ExpressionNumber {
    // 투 포인터를 이용한 풀이
    public int solution(int n) {
        int answer = 0;
        int start = 1, end = 1;
        int sum = 1;
        
        while(start <= n){
            if(sum < n){
                end++;
                sum += end;
            }
            else if(sum > n){
                sum -= start;
                start++;
            }
            else{
                answer++;
                sum -= start;
                start++;
            }
        }
        return answer;
    }
    
    // Queue를 이용한 풀이
    public int solutionWithQueue(int n) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.offer(i);
            sum += i;
            if(sum < n) continue;
            if(sum > n)
                while(sum > n)
                    sum -= q.poll();
                
            if(sum == n) answer++;
        }
        return answer;
    }
}