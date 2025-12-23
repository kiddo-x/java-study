// 프로그래머스 - N으로 표현 ㅣ Level 3
// https://school.programmers.co.kr/learn/courses/30/lessons/42895
// DP, Set 사용

package programmers.level_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressWithN {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) dp.add(new HashSet<>());
        
        dp.get(1).add(N);
        
        for (int i = 2; i <= 8; i++) {
            int concat = 0;
            for (int j = 1; j <= i; j++) 
                concat = concat*10 + N;
            
            dp.get(i).add(concat);
            
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i-j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            
            if (dp.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}
