// 2020-10-09 Yoo Jaein
// [BOJ] 10026 적록색약
// BFS

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int n;
	
	static Queue<Pair> queue = new LinkedList<>();
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int color) {
		while(!queue.isEmpty()) {
			Pair v = queue.poll();
			
			for(int i=0; i<4; i++) {
				int cx = v.x + dx[i];
				int cy = v.y + dy[i];
				
				if(cx<0 || cy<0 || cx>=n || cy>=n) continue;
				
				if(!visited[cx][cy] && map[cx][cy]==color) {
					queue.add(new Pair(cx, cy));
					visited[cx][cy] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		
		// R=0, G=1, B=2로 변환
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<n; j++) {
				if(s[j].equals("R"))
					map[i][j] = 0;
				else if(s[j].equals("G"))
					map[i][j] = 1;
				else
					map[i][j] = 2;
			}
		}
		
		int red = 0;
		int green = 0;
		int blue = 0;
		
		// 적록색약이 아닌 사람
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					queue.add(new Pair(i, j));
					bfs(map[i][j]);
					
					if(map[i][j]==0) red++;
					else if(map[i][j]==1) green++;
					else blue++;
				}
			}
		}
		System.out.print(red+green+blue+" ");
		
		// 적록색약인 사람
		visited = new boolean[n][n];
		red = green = blue = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 초록색을 빨간색으로 변환
				if(map[i][j]==1)
					map[i][j] = 0;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					queue.add(new Pair(i, j));
					bfs(map[i][j]);
					
					if(map[i][j]==0) red++;
					else blue++;
				}
			}
		}
		System.out.println(red+blue);
		
		br.close();
    	return;
    }
}