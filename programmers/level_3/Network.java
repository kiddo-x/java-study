package programmers.level_3;

public class Network {
    
    int n;
    int[][] computers;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        this.n = n;
        this.computers = computers;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int index){
        visited[index] = true;
        
        for(int i=0; i<n; i++)
            if(!visited[i] && computers[index][i] == 1)
                dfs(i);
    }
}