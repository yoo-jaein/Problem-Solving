// 2020-10-08 Yoo Jaein
// [BOJ] 2178 미로 탐색
// BFS

import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] arr;
	static int[][] visited;
	
	static Queue<Pair> queue = new LinkedList<>();
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
				int cx = t.x + dx[i];
				int cy = t.y + dy[i];
				
				if(cx<0 || cy<0 || cx>=n || cy>=m) continue;
				
				if(arr[cx][cy]==1 && visited[cx][cy]==0) {
					queue.add(new Pair(cx, cy));
					visited[cx][cy] = visited[t.x][t.y]+1;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		arr = new int[n][m];
		visited = new int[n][m];
		
		queue.add(new Pair(0,0));
		visited[0][0] = 1;
		
		for(int i=0; i<n; i++) {
			String[] s2 = br.readLine().split("");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(s2[j]);
			}
		}
		
		bfs();
		
		System.out.println(visited[n-1][m-1]);
		
		br.close();
    	return;
    }
}