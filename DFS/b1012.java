// 2020-08-10 Yoo Jaein
// [BOJ] 1012 유기농 배추
// DFS

import java.io.*;
import java.util.*;

public class Main {
	static int[][] a;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0}; // 상하좌우
	static boolean[][] visited;
	static int N, M;
	static int cnt = 0;
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		// 네 방향 탐색
		for(int i=0; i<4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			if(cx >= 0 && cy >= 0 && cx < M && cy < N) {
				if(!visited[cx][cy] && a[cx][cy] == 1)
					dfs(cx, cy);
			}
			
		}
	}
	
	public static void dfsAll() {
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && a[i][j] == 1) {
					dfs(i,j);
					cnt++;
				}
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<T; i++) {
    		cnt = 0;
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		M = Integer.parseInt(st.nextToken());
    		N = Integer.parseInt(st.nextToken());
    		int K = Integer.parseInt(st.nextToken());
    		
    		a = new int[M][N];
    		visited = new boolean[M][N];
    		
    		for(int j=0; j<K; j++) {
    			st = new StringTokenizer(br.readLine(), " ");
    			int X = Integer.parseInt(st.nextToken());
    			int Y = Integer.parseInt(st.nextToken());
    			a[X][Y] = 1;
    		}

        	dfsAll();
        	System.out.println(cnt);
    	}
    	
		
    	return;
    }
}
