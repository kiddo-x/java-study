// 프로그래머스 - 보행자 천국 level 3
// https://school.programmers.co.kr/learn/courses/30/lessons/1832
// DP를 활용한 경로 탐색 문제

package programmers.level_3;

public class PedestrianParadise {
    
    static final int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];
        
        if (cityMap[0][1] != 1) dp[0][1][1] = 1;
        if (cityMap[1][0] != 1) dp[1][0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (i == 0 && j <= 1) continue;
                if (j == 0 && i <= 1) continue;
                if (cityMap[i][j] == 1) continue;
                
                // 내려오는 경우
                if (i > 0){
                    if (cityMap[i-1][j] == 2) {
                        dp[i][j][0] = dp[i-1][j][0]; 
                    } else {
                        dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD;
                    }
                }
                
                // 왼쪽에서 오는 경우
                if (j > 0){
                    if (cityMap[i][j-1] == 2) {
                        dp[i][j][1] = dp[i][j-1][1]; 
                    } else {
                        dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % MOD;
                    }
                }
            }
        }
        
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}
