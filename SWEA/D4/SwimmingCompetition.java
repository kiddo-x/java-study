// SWEA - D4 - 수영대회 결승전
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWX1zE6qD0MDFAUo
// BFS 활용
// queue 직접 구현 (memory pool 문제 해결을 위해)

package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwimmingCompetition {
    static int[][] q = new int[10000][3];
    static int front = 0;
    static int rear = 0;
    static void push(int[] value) { q[rear++] = value; }
    static int[] pop() { return q[front++]; }
    static boolean isEmpty() { return front == rear; }
     
    static int[][] map = new int[15][15];
    static int[][] visited = new int[15][15];
     
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
     
    static boolean inRange(int y, int x, int n) {
        return y >= 0 && y < n && x >= 0 && x < n; 
    }
     
    static void bfs(int sy, int sx, int ey, int ex, int n, int tc) {
        front = 0; rear = 0;
        push(new int[]{sy, sx, 0});
        visited[sy][sx] = tc;
         
        while (!isEmpty()) {
            int[] cur = pop();
            int cy = cur[0], cx = cur[1], t = cur[2];
             
            if (cy == ey && cx == ex) {
                System.out.println("#" + tc + " " + t);
                return;
            }
             
            for (int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                int nt = (t + 1) % 3;
                 
                if (!inRange(ny, nx, n)) continue;
                if (visited[ny][nx] == tc) continue;
                if (map[ny][nx] == 1) continue;
                 
                if (nt != 0 && map[ny][nx] == 2) {
                    push(new int[]{cy, cx, t+1});
                } else {
                    visited[ny][nx] = tc;
                    push(new int[]{ny, nx, t+1});
                }
            }
        }
        System.out.println("#" + tc + " " + (-1));
    }
     
    public static void main(String args[]) throws Exception
    {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());
     
 
        for(int tc = 1; tc <= T; tc++)
        {
            int n = Integer.parseInt(br.readLine());
            for (int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) 
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken()), sx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ey = Integer.parseInt(st.nextToken()), ex = Integer.parseInt(st.nextToken());
             
            bfs(sy, sx, ey, ex, n, tc);
 
        }
    }
}
