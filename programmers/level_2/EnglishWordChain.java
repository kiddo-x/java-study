// 프로그래머스 Level 2 - 영어 끝말잇기
// https://school.programmers.co.kr/learn/courses/30/lessons/12981
// Set 이용

package programmers.level_2;

import java.util.HashSet;
import java.util.Set;

public class EnglishWordChain {
    
    public int[] solution(int n, String[] words) {
        
        Set<String> wordSet = new HashSet<>();
        
        for(int i=0; i<words.length; i++){
            int people = i % n + 1;
            int order = i / n + 1;
            
            if(i > 0)  
                if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))
                   return new int[]{people, order};
            
            if(wordSet.contains(words[i])) 
                return new int[]{people, order};
            
            wordSet.add(words[i]);
        }
        
        return new int[]{0, 0};
    }
}
