// SWEA - D4 - 서로소 집합
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWX1yE6qD0MDFAUo
// Union-Find 자료구조 활용

package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DisjointSet {
    static int[] parent = new int[1000001];
    
    static void union(int a, int b) {
    	int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
        return;
    }
    static int find(int x) {
    	if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            for (int i=0; i<=n; i++) parent[i] = i;
            
            System.out.print("#" + test_case + " ");
            for (int i=0; i<m; i++) {
            	st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if (op == 0) {
                    union(a, b);
                	continue;
                }
                if (find(a) == find(b)) {
                	System.out.print(1);
                } 
                else System.out.print(0);
            }
            System.out.println();
		}
	}
}
