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
