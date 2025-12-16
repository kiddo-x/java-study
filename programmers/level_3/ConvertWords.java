// 프로그래머스 Level 3 - 단어 변환
// https://school.programmers.co.kr/learn/courses/30/lessons/43163
// BFS 

package programmers.level_3;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertWords {
    
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.offer(new Word(begin, 0));
        
        int answer = 0;
        while(!q.isEmpty()){
            Word cur = q.poll();
            
            if(cur.word.equals(target))
                return cur.depth;
            
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && check(cur.word, words[i])){
                    visited[i] = true;
                    q.offer(new Word(words[i], cur.depth+1));
                }
            }
        }
        
        return 0;
    }
    
    static class Word {
        String word;
        int depth;
        
        Word(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    
    private boolean check(String a, String b){
        int diff = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
                if(diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
