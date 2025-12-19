// 프로그래머스 - 입국심사 level 3
// https://school.programmers.co.kr/learn/courses/30/lessons/43238
// 이분 탐색 사용

package programmers.level_3;

import java.util.Arrays;

public class EntryScreening {
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 0;
        long right = (long) times[times.length-1] * n;
        long answer = right;
        
        while (left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
  
            for (int time : times){
                sum += mid / time;
                if (sum > n) break;
            }
            
            if (sum >= n){
                right = mid-1;
                answer = mid;
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
}
