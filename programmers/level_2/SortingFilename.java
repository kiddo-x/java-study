// 프로그래머스 Level 2 - 파일명 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/17686
// 정규표현식, Comparator 이용
// 문자열 처리, 정렬

package programmers.level_2;

import java.util.*;
import java.util.regex.*;

class SortingFilename {
    private class fileName{
        String head, number, tail;
        int index;
        
        fileName(String head, String number, String tail, int index){
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.index = index;
        }
    };
    
    public String[] solution(String[] files) {
        
        List<fileName> fileList = new ArrayList<>();
        Pattern p = Pattern.compile("(\\D+)(\\d{1,5})(.*)");
        
        int idx = 0;
        for(String s : files){
            Matcher m = p.matcher(s);
            if(m.find())
                fileList.add(new fileName(
                    m.group(1), 
                    m.group(2), 
                    m.group(3), 
                    idx++
                ));
        }
        
        Collections.sort(fileList, 
            Comparator
                .comparing((fileName f) -> f.head.toLowerCase())
                .thenComparing(f -> Integer.parseInt(f.number))
                .thenComparing(f -> f.index)                
        );
        
        return fileList
            .stream()
            .map(f -> f.head + f.number + f.tail)
            .toArray(String[]::new);
    }
}