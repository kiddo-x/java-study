// 프로그래머스 Level 3 - 디스크 컨트롤러
// https://school.programmers.co.kr/learn/courses/30/lessons/42627
// 우선순위 큐, 정렬
package programmers.level_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
    
    private static class Process{
        int requestTime;
        int duration;
        
        Process(int requestTime, int duration){
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> {
            return Integer.compare(a[0], b[0]);   
        });
        
        PriorityQueue<Process> disk = new PriorityQueue<>(
            Comparator.comparingInt(p -> p.duration)
        );
        
        int completed = 0;
        int time = 0;
        int returnTime = 0;
        int idx = 0;
        
        while(completed < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= time){
                disk.offer(new Process(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(!disk.isEmpty()){
                Process p = disk.poll();
                time += p.duration;
                returnTime += time - p.requestTime;
                completed++;
            }
            else time = jobs[idx][0];
            
        }
        
        return (int)returnTime/jobs.length;
    }
}
