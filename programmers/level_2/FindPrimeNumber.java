// 프로그래머스 - 소수 찾기 level 2
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
// DFS(깊이 우선 탐색) 이용, 소수 판별

package programmers.level_2;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {
    
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs(0, "", numbers);
        return countPrime(set);
    }
    
    private void dfs(int depth, String num, String numbers){
        if(!num.equals(""))
            set.add(Integer.parseInt(num));
        
        if(depth == numbers.length()) 
            return;
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(depth+1, num+numbers.charAt(i), numbers);
            visited[i] = false;
        }
    }
    
    private int countPrime(Set<Integer> set){
        int count = 0;
        
        for(int num : set)
            if(isPrime(num)) count++;
        
        return count;
    }
    
    private boolean isPrime(int num){
        if(num <= 1) return false;
        
        int limit = (int)Math.sqrt(num);
        for(int i = 2; i <= limit; i++)
            if(num % i == 0) return false;
        
        return true;
    }
}
