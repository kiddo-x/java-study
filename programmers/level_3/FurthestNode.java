// 프로그래머스 - 가장 먼 노드 ㅣ Level 3
// https://school.programmers.co.kr/learn/courses/30/lessons/49189
// BFS 사용, 인접 리스트로 그래프 표현

package programmers.level_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FurthestNode {
    
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        
        
        for(int[] e : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph[cur]){
                if(dist[next] == -1){
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        int maxDist = 0;
        for(int d : dist)
            maxDist = Math.max(d, maxDist);
        
        int answer = 0;
        for(int d : dist)
            if(d == maxDist) 
                answer++;
        
        return answer;
    }
}
