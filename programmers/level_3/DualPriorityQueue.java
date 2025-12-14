// 프로그래머스 - 이중우선순위큐 (level 3)
// https://school.programmers.co.kr/learn/courses/30/lessons/42628
// 트리맵

package programmers.level_3;

import java.util.TreeMap;

public class DualPriorityQueue {
    
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String s : operations){
            String[] split = s.split(" ");
            String operation = split[0];
            int num = Integer.parseInt(split[1]);
            
            if(operation.equals("I")){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            if(map.isEmpty()) continue;
            if(operation.equals("D")) {
                int key = (num == 1) ? map.lastKey() : map.firstKey();
                map.put(key, map.get(key) - 1);
                
                if(map.get(key) == 0)
                    map.remove(key);
            }
        }
        
        if(map.isEmpty()) return new int[]{0, 0};
        
        return new int[]{map.lastKey(), map.firstKey()};
    }
}
