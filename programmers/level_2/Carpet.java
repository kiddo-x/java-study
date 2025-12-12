//프로그래머스 Level 2 카펫
//https://school.programmers.co.kr/learn/courses/30/lessons/42842
// 완전 탐색

package programmers.level_2;

class Carpet {
    public int[] solution(int brown, int yellow) {
        
        int limit = (int)Math.sqrt(yellow);
        for(int h = 1; h <= limit; h++){
            if(yellow % h == 0){
                int w = yellow / h;
                int outline = 2*w + 2*h + 4;
                if (outline == brown) 
                    return new int[]{w+2, h+2};
            }
        }
        return new int[0];
    }
}