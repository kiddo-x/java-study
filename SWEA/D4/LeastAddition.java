// SWEA - D4 - 최소 덧셈
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWX1yE6qD0MDFAUo
// 재귀(DFS) 활용

package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LeastAddition {
    static int answer;
    
    static void dfs(int index, String s) {
    	if (index == s.length()) { return; }
        
        String s1 = s.substring(0, index);
        String s2 = s.substring(index, s.length());
        answer = Math.min(answer, Integer.parseInt(s1) + Integer.parseInt(s2));
        
        dfs(index+1, s);
    }
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = br.readLine();
            answer = Integer.MAX_VALUE;
            dfs(1, s);
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
