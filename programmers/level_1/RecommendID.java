// 프로그래머스 - 신규 아이디 추천 (Level 1)
// https://school.programmers.co.kr/learn/courses/30/lessons/72410
// String 처리, StringBuilder, 정규표현식 사용 풀이

public class RecommendID {
    
    public String solution(String new_id) {
        String step1 = new_id.toLowerCase();
        
        String step2 = step1.replaceAll("[^-_.\\d\\w]","");
        
        String step3 = step2.replaceAll("[.]+",".");
        
        String step4 = step3.replaceAll("^[.]|[.]$","");
        
        String step5 = step4.isEmpty()? "a" : step4;
        
        String step6 = step5.length() >= 16 ? 
            step5.substring(0, 15).replaceAll("[.]$","") : step5;
        
        StringBuilder step7 = new StringBuilder(step6);
        while(step7.length() < 3)
            step7.append(step7.charAt(step7.length()-1));
        
        return step7.toString();
    }
}