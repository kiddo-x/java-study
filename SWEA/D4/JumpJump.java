// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWX1xhakD0MDFAUo
// SWEA - D4 - 점프점프
// 다각형의 성립 조건을 활용한 수학적 풀이

package SWEA.D4;

import java.util.*;
import java.io.*;

public class JumpJump {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long X = Math.abs(Integer.parseInt(st.nextToken()));
            long[] d = new long[N];
            long sumN = 0;
            long maxD = 0;
		
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                d[i] = Integer.parseInt(st.nextToken());;
                sumN += d[i];
                maxD = Math.max(maxD, d[i]);
            }

            System.out.println( solve(N, X, d, sumN, maxD));
        }
    }

    private static long solve(int N, long X, long[] d, long sumN, long maxD) {
        if (X == 0) return 0;

        long currentSum = 0;
        long currentMax = 0;

        // 1. k = 1부터 N까지 확인
        for (int k = 1; k <= N; k++) {
            currentSum += d[k - 1];
            currentMax = Math.max(currentMax, d[k - 1]);

            if (k == 1) {
                if (d[0] == X) return 1;
            } else {
                // 다각형 성립 조건: 2 * Max <= Sum + X
                long totalSum = currentSum + X;
                long totalMax = Math.max(currentMax, X);
                if (2 * totalMax <= totalSum) return k;
            }
        }

        // 2. k > N 인 경우 (수학적으로 점프)
        // 조건을 만족하기 위한 최소 Sum을 구함
        // 조건 1: Sum >= X
        // 조건 2: Sum + X >= 2 * maxD => Sum >= 2 * maxD - X
        long targetSum = Math.max(X, 2 * maxD - X);
        
        // 이미 k=N까지 확인했으므로 targetSum은 currentSum보다 클 것임
        long needed = targetSum - currentSum;
        long fullCycles = needed / sumN;
        
        long k = N + fullCycles * N;
        long totalSum = currentSum + fullCycles * sumN;

        // 남은 거리만큼 k를 하나씩 증가시키며 확인
        while (totalSum < targetSum) {
            totalSum += d[(int)(k % N)];
            k++;
        }

        return k;
    }
}
