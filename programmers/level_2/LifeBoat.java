// 프로그래머스 Level 2 - 구명보트
// https://school.programmers.co.kr/learn/courses/30/lessons/42885
// 그리디 알고리즘, Deque 이용
// 투 포인터 이용한 풀이도 포함

package programmers.level_2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LifeBoat {
    
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        Deque<Integer> peopleList = new ArrayDeque<>();
        for(int p : people) 
            peopleList.offerLast(p);
        
        int answer = 0;
        while(!peopleList.isEmpty()){
            if(peopleList.size() == 1) { answer++; break; }
            
            int bigGuy = peopleList.pollLast();
            int smallGuy = peopleList.peek();
            
            if(bigGuy + smallGuy <= limit) 
                peopleList.pollFirst();
            
            answer++;
        }
        return answer;
    }
    
    public int solutionWithTwoPointer(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0; 
        int right = people.length - 1;
        int answer = 0;
        
        while(left <= right){
            if(people[left] + people[right] <= limit) 
                left++;

            right--;
            answer++;
        }
        return answer;
    }
}
