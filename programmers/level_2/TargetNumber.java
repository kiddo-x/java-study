//프로그래머스 타겟 넘버 - level 2
//https://school.programmers.co.kr/learn/courses/30/lessons/43165
// DFS(깊이 우선 탐색) 이용 

package programmers.level_2;

public class TargetNumber {
    int targetNumber;
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        targetNumber = target;
        answer = 0;
        dfs(numbers, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int index, int sum){
        if(index == numbers.length){
            if(sum == targetNumber) answer++;
            return;
        }
        
        int n = numbers[index];
        dfs(numbers, index+1, sum+n);
        dfs(numbers, index+1, sum-n);
    }
}
