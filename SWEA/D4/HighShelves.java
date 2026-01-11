package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HighShelves {
    static int[] p = new int[20];
    static int minHeight;
     
    static void dfs(int index, int sum, int[] p, int n, int b) {
        if (sum >= b) {
            minHeight = Math.min(minHeight, sum);
            return;
        }
        if (index == n) return;
        if (sum >= minHeight) return;
         
        dfs(index+1, sum+p[index], p, n, b);
        dfs(index+1, sum, p, n, b);
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
            int b = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++) 
                p[i] = Integer.parseInt(st.nextToken());
             
            minHeight = Integer.MAX_VALUE;
            dfs(0, 0, p, n, b);
             
            System.out.println("#" + test_case + " " + (minHeight-b));
             
        }
    }
}
