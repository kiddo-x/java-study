// 프로그래머스 Level 3 - 단속카메라
// https://school.programmers.co.kr/learn/courses/30/lessons/42884
// Greedy

package programmers.level_3;

import java.util.Arrays;

public class TrafficCamera {
    
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int camera = routes[0][1];
        int answer = 1;
        
        for(int[] route : routes){
            if(camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
}
