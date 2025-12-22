// 프로그래머스 - 정수 삼각형 level 3
// https://school.programmers.co.kr/learn/courses/30/lessons/43105
// DP

package programmers.level_3;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        int answer = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) continue;
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } 
                else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } 
                else {
                    int m = Math.max(dp[i-1][j], dp[i-1][j-1]);
                    dp[i][j] = m + triangle[i][j];
                }
                
                if (i == n - 1) {
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        
        return answer;
    }
}
