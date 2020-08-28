// 2020-08-27 Yoo Jaein
// [BOJ] 7576 토마토
// BFS

import java.io.*;
import java.util.*;

public class Main {

	static int m, n;
	static int[][] box;
	static int[][] visited;
	
	static Queue<Pair> queue = new LinkedList<>();
	static int result;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Pair{
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			Pair t = queue.poll();
			
			for(int i=0; i<4; i++) {
				int tx = t.x+dx[i];
				int ty = t.y+dy[i];
				
				// 범위 주의!
				if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
				
				if(box[tx][ty]==0 && visited[tx][ty]==0) {
					queue.add(new Pair(tx, ty));
					box[tx][ty] = 1;
					result = visited[tx][ty] = visited[t.x][t.y]+1;
				}
			}
		}
		
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	String[] s = br.readLine().split(" ");
    	m = Integer.parseInt(s[0]);
    	n = Integer.parseInt(s[1]);
    	box = new int[n][m];
    	visited = new int[n][m];
    	
    	for(int i=0; i<n; i++) {
    		String[] st = br.readLine().split(" ");
    		
    		for(int j=0; j<m; j++) {
    			box[i][j] = Integer.parseInt(st[j]);
    			
    			// 익은 토마토만 큐에 넣는다 -> 시간 단축
    			if(box[i][j]==1) queue.add(new Pair(i,j));
    		}
    	}
    	    	
    	bfs();
    	
    	// 덜 익은 토마토 찾기
		boolean flag = true;
		outer:
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(box[i][j]==0) {
    				flag = false;
    				break outer;
    			}
    		}
    	}
    	
		// System.out.println(flag?result:-1);
		if(flag)
			System.out.println(result);
		else
			System.out.println("-1");
    	
		br.close();
    	return;
    }
}
