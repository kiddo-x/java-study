//프로그래머스 Lv.1 숫자 문자열과 영단어
// https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=java
// String.replace 활용 풀이

public class NumberString {
    
    public int solution(String s) {
        String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for (int i = 0; i < 10; i++) {
            s = s.replace(words[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}

