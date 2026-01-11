// SWEA - D4 - 지뢰찾기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWX1zE6qD0MDFAUo
// BFS 활용
// queue 직접 구현 (memory pool 문제 해결을 위해)
// 1차원 배열과 비트 연산을 활용한 메모리 최적화

package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Minesweeper {
    
    static char[][] map = new char[300][300];
    static int[][] mineMap = new int[300][300];
    static int[][] visited = new int[300][300];
    
    static final int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    
	static int[] q = new int[100000]; // 1차원 배열로 변경
	static int front, rear;

	static void bfs(int y, int x, int n, int tc) {
    	front = 0; rear = 0;
    	q[rear++] = (y << 10) | x; // 비트 패킹
    	visited[y][x] = tc;
    
    	while (front != rear) {
        	int cur = q[front++];
        	int cy = cur >> 10;
        	int cx = cur & 0x3FF;
        
        	// 0인 지점에서만 전파
        	if (mineMap[cy][cx] != 0) continue; 

        	for (int i=0; i<8; i++) {
            	int ny = cy + dy[i];
            	int nx = cx + dx[i];
            
            	if (inRange(ny, nx, n) && visited[ny][nx] != tc && mineMap[ny][nx] != -1) {
                	visited[ny][nx] = tc;
                	// 주변 칸이 0일 때만 큐에 넣어 더 퍼뜨림
                	if (mineMap[ny][nx] == 0) {
                    	q[rear++] = (ny << 10) | nx;
                	}
            	}
        	}
    	}
	}
    
    static boolean inRange(int y, int x, int n) {
    	return y >= 0 && y < n && x >= 0 && x < n;
    }
    
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());


		for(int tc = 1; tc <= T; tc++)
		{
			int n = Integer.parseInt(br.readLine());
            for (int i=0; i<n; i++) {
            	map[i] = br.readLine().toCharArray();
            }
            // 지뢰 개수 표시
            for (int i=0; i<n; i++) {
            	for (int j=0; j<n; j++) {
                	if (map[i][j] == '*') {
                    	mineMap[i][j] = -1;
                        continue;
                    } 
                    int cnt = 0;
                    for (int d=0; d<8; d++) {
                    	int di = i + dy[d];
                        int dj = j + dx[d];
                        if (inRange(di, dj, n) && map[di][dj] == '*') cnt++;
                    }	
                    mineMap[i][j] = cnt;
                }
            }
            
            // 0인 칸부터 클릭
            int clicks = 0;
            for (int i=0; i<n; i++) {
            	for (int j=0; j<n; j++) {
                	if (mineMap[i][j] == 0 && visited[i][j] != tc) {
                    	bfs(i, j, n, tc);
                        clicks++;
                    }
                }
            }
            
            // 남은 칸 클릭
            for (int i=0; i<n; i++) {
            	for (int j=0; j<n; j++) {
                	if (visited[i][j] != tc && mineMap[i][j] != -1 ) {
                    	visited[i][j] = tc;
                        clicks++;
                    }
                }
            }
            
            System.out.println("#" + tc + " " + clicks);
            
		}
	}
}
