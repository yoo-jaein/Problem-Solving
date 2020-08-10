// 2020-08-10 Yoo Jaein
// [BOJ] 2667 단지번호붙이기
// DFS

import java.io.*;
import java.util.*;

public class Main {
	static int[][] a;
	static boolean[][] visited;
	static ArrayList<Integer> houses;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int N;
	static int cnt = 0;
	static int house;
	
	public static void dfs(int x, int y) {		
		visited[x][y] = true;
		
		house++;
		
		for(int i=0; i<4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			if(cx>=0 && cy>=0 && cx<N && cy<N) {
				if(!visited[cx][cy] && a[cx][cy]==1) {
					dfs(cx,cy);
				}
			}
		}
		
	}
	
	public static void dfsAll() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && a[i][j]==1) {
					house = 0;
					dfs(i,j);
					houses.add(house);
					cnt++;
				}
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	N = Integer.parseInt(br.readLine());
    	
		houses = new ArrayList<>();
		visited = new boolean[N][N];
		a = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<N; j++) {
				a[i][j] = Integer.parseInt(s[j]);
			}
		}

    	dfsAll();
    	System.out.println(cnt);
    	
    	Collections.sort(houses);
    	for(int i : houses)
    		System.out.println(i);
		
    	return;
    }
}
