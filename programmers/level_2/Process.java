// 프로그래머스 Level 2 - 프로세스
// https://school.programmers.co.kr/learn/courses/30/lessons/42587
// Queue, PriorityQueue 이용

package programmers.level_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Process {
    
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> process = new LinkedList<>();
        for(int p : priorities) {
            pQ.offer(p);
            process.offer(p);
        }
        
        int answer = 0;
        while(!process.isEmpty()){
            if(process.peek() == pQ.peek()){
                process.poll();
                pQ.poll();
                answer++;
                
                if(location == 0) return answer;
                
                location--;
            }
            else {
                process.offer(process.poll());
                location--;
                if(location < 0) location = process.size() - 1;
            }
        }
        return answer;
    }
}
