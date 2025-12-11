// 프로그래머스 - H-Index level 2
// https://school.programmers.co.kr/learn/courses/30/lessons/42747
// Arrays.sort 이용

package programmers.level_2;

import java.util.Arrays;

public class H_index {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int l = citations.length;
        
        for(int h = l; h >= 0; h--){
            int idx = l - h;
            if( idx < l && citations[idx] >= h) 
                return h;
        }
        return 0;
    }
}
