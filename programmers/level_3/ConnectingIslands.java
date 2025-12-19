// 프로그래머스 - 레벨 3 - 섬 연결하기
// https://school.programmers.co.kr/learn/courses/30/lessons/42861
// Kruskal 알고리즘 사용
// MST (Minimum Spanning Tree)
// Union-Find 자료구조 활용

package programmers.level_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConnectingIslands {
    
    static class Edge {
        int from, to, cost;
        
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        List<Edge> edges = new ArrayList<>();
        for (int[] c : costs)
            edges.add(new Edge(c[0], c[1], c[2]));
        
        edges.sort(Comparator.comparingInt(e -> e.cost));
        
        parent = new int[n];
        for (int i=0; i<n; i++)
            parent[i] = i;
        
        int answer = 0;
        int count = 0;
        for (Edge edge : edges){
            if (find(edge.from) != find(edge.to)){
                union(edge.from, edge.to);
                answer += edge.cost;
                count++;
            }
            
            if (count == n-1) break;
        }
        return answer;
    }
    
    int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    void union (int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if (pa != pb)
            parent[pb] = pa;
    }
}
