// 프로그래머스 Level 3 - 베스트앨범
// https://school.programmers.co.kr/learn/courses/30/lessons/42579
// HashMap, List 이용
// Sorting

package programmers.level_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {
    private static class Music {
        int play;
        int index;
        
        Music(int play, int index){
            this.play = play;
            this.index = index;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlays = new HashMap<>();
        Map<String, List<Music>> genreMap = new HashMap<>();
        
        for(int i=0; i<plays.length; i++){
            // 장르별 총 재생 횟수
            genrePlays.merge(genres[i], plays[i], Integer::sum);
            
            // 장르별 노래 리스트
            genreMap.computeIfAbsent(genres[i], k -> new ArrayList<>())
                .add(new Music(plays[i], i));
        }
        
        // 장르 정렬 (재생 횟수 내림차순)
        List<String> genreOrder = genrePlays.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .map(Map.Entry::getKey)
            .toList();
        
        List<Integer> answer = new ArrayList<>();
        
        for(String genre : genreOrder){
            List<Music> musicList = genreMap.get(genre);
            
            //장르 내부 정렬
            musicList.sort(
                Comparator.comparing((Music m) -> m.play).reversed()
                    .thenComparing(m -> m.index)
            );
            
            // 상위 2곡 고유 번호
            for(int i=0; i< Math.min(2, musicList.size()); i++)
                answer.add(musicList.get(i).index);
            
        }
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}
