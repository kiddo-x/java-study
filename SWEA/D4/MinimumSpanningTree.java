// SWEA - D4 - 최소 스패닝 트리
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWX1yE6qD0MDFAUo
// Kruskal 알고리즘 활용
// Union-Find 자료구조 활용

package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinimumSpanningTree {
    static class Edge implements Comparable<Edge> {
    	int from, to, cost;
        
        void set (int from, int to, int cost) {
        	this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o) {
        	return this.cost - o.cost;
        }
    };
    
    static final int MAX_E = 200001;
    static Edge[] edges = new Edge[MAX_E];
    static {
    	for (int i=0; i<MAX_E; i++) edges[i] = new Edge();
    }
    
    static final int MAX_V = 100001;
    static int[] parent = new int[MAX_V];
    
    static void union(int a, int b) {
    	int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
        return;
    }
    static int find(int x) {
    	int root = x;
        while (parent[root] != root) {
        	root = parent[root];
        }
        
        while (parent[x] != root) {
        	int next = parent[x];
            parent[x] = root;
            x = next;
        }
        
        return root;
    }
    
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T= Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            for (int i=1; i<=V; i++) {
            	parent[i] = i;
            }

            for (int i=0; i<E; i++) {
            	st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges[i].set(a, b, c);
            }
            
            Arrays.sort(edges, 0, E);
            long sum = 0;
            int count = 0;
            for (int i=0; i<E; i++) {
                int a = edges[i].from;
                int b = edges[i].to;
            	if (find(a) != find(b)) {
                	union(a, b);
                    sum += edges[i].cost;
                    count++;
                }
                if (count == V-1) break;
            }
            
            System.out.println("#" + test_case + " " + sum);
		}
	}
}
