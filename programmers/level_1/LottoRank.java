// 프로그래머스 - 로또의 최고 순위와 최저 순위 (LV1)
// https://school.programmers.co.kr/learn/courses/30/lessons/77484
// Set 자료구조를 활용한 풀이

import java.util.HashSet;
import java.util.Set;

public class LottoRank {

    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();
        for (int n : win_nums) winSet.add(n);

        int zeroCount = 0;
        int correctCount = 0;

        for (int n : lottos) {
            if (n == 0) zeroCount++;
            else if (winSet.contains(n)) correctCount++;
        }

        int[] rank = {6, 6, 5, 4, 3, 2, 1};

        return new int[]{
                rank[correctCount + zeroCount],
                rank[correctCount]
        };
    }
}
