// 프로그래머스 - 모의고사 (Lv1)
// https://school.programmers.co.kr/learn/courses/30/lessons/42840
// ArrayList 사용

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam {
    private final int[] spz1 = {1, 2, 3, 4, 5};
    private final int[] spz2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] spz3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == spz1[i % spz1.length]) score[0]++;
            if(answers[i] == spz2[i % spz2.length]) score[1]++;
            if(answers[i] == spz3[i % spz3.length]) score[2]++;
        }    
        
        int max = Arrays.stream(score).max().getAsInt();
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(score[i] == max) list.add(i+1);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
