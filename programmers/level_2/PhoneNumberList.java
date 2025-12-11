//프로그래머스 - 전화번호 목록 level 2
//https://school.programmers.co.kr/learn/courses/30/lessons/42577
// Arrays.sort, String.indexOf 이용

package programmers.level_2;

import java.util.Arrays;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++)
            if(phone_book[i+1].indexOf(phone_book[i]) == 0) 
                return false;
        return true;
    }
}
