// 프로그래머스 Level 2 - 이진 변환 반복하기
// https://school.programmers.co.kr/learn/courses/30/lessons/70129
// 문자열, 구현
package programmers.level_2;

public class BinaryConversion {
    public int[] solution(String s) {
        int zeroCount = 0;
        int conversionCount = 0;
        
        while(!s.equals("1")){
            conversionCount++;
            
            int originLength = s.length();
            s = s.replace("0", "");
            zeroCount += originLength - s.length();
            
            s = Integer.toBinaryString(s.length());
        }
        
        return new int[]{conversionCount, zeroCount};
    }
}
