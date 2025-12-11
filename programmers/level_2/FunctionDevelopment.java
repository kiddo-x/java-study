//프로그래머스 - 기능개발
//https://school.programmers.co.kr/learn/courses/30/lessons/42586
// ArrayList, Queue 사용, Math.ceil 이용(올림)

package programmers.level_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> process = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            // 올림 계산할 때 double 형 변환 필요
            int days = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
            process.offer(days);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        while(!process.isEmpty()){
            int deployDay = process.poll();
            int count = 1;
            
            while(!process.isEmpty() && process.peek() <= deployDay){
                process.poll();
                count++;
            }
            answer.add(count);
        }
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
