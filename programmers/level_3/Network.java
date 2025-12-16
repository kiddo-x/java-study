package programmers.level_3;

public class Network {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, n, visited, computers);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int index, int n, boolean[] visited, int[][]computers){
        visited[index] = true;
        
        for(int i=0; i<n; i++){
            if(!visited[i] && computers[index][i] == 1){
                dfs(i, n, visited, computers);
            }
        }
    }
}