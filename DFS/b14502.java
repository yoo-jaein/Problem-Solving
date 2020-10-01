// 2020-10-01 Yoo Jaein
// [BOJ] 14502 연구소
// DFS

import java.io.*;
import java.util.*;

public class Main {
	static int max = 0;
	
	static int[][] map;
	static int[][] walls;
	static int n, m;
	
	static boolean[][] visited;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		walls[x][y] = 2;
		
		for(int i=0; i<4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			if(cx<0 || cy<0 || cx>=n || cy>=m)
				continue;
			
			if(!visited[cx][cy] && walls[cx][cy]==0)
				dfs(cx, cy);
		}
		
	}
	
	public static void area() {
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(walls[i][j]==0)
					sum++;
			}
		}
		
		//max = Math.max(sum, max);
		if(sum>max) {
			//printMap();
			max = sum;
		}
		
	}
	
	public static void printMap() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(walls[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void makeWalls() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(walls[i][j]!=0) continue;
				
				for(int a=0; a<n; a++) {
					for(int b=0; b<m; b++) {
						if(walls[a][b]!=0) continue;
						if(i==a && j==b) continue;
						
						for(int p=0; p<n; p++) {
							for(int q=0; q<m; q++) {
								if(walls[p][q]!=0) continue;
								if(i==p && j==q) continue;
								if(a==p && b==q) continue;
								
								
								walls[i][j] = 1;
								walls[a][b] = 1;
								walls[p][q] = 1;
								
								dfsAll();
								area();
								
								copyMap();
								initVisited();
							}
						}
						
					}
				}
				
			}
		}
	}
	
	public static void copyMap() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				walls[i][j] = map[i][j];
			}
		}
	}

	public static void dfsAll() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && walls[i][j]==2)
					dfs(i, j);
			}
		}
		
	}
	
	public static void initVisited() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		map = new int[n][m];
		walls = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String[] s2 = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(s2[j]);				
			}
		}
		
		copyMap();
		makeWalls();
		
		System.out.println(max);
		
		br.close();
    	return;
    }
}