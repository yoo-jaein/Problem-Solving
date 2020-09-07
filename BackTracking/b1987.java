// 2020-09-07 Yoo Jaein
// [BOJ] 1987 알파벳
// BackTracking

import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static boolean[] visited;
	static int max;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void dfs(int cnt, int x, int y) {
		visited[map[x][y]-'A'] = true;
		
		for(int i=0; i<4; i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			
			if(cx<0 || cy<0 || cx>=R || cy>=C) continue;
			
			if(!visited[map[cx][cy]-'A']) {
				dfs(cnt+1, cx, cy);
				visited[map[cx][cy]-'A'] = false;
			}
		}
		
		if(cnt>max)
			max = cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		
		visited = new boolean[26];
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String[] st = br.readLine().split("");
			for(int j=0; j<C; j++) {
				map[i][j] = st[j].charAt(0);
			}
		}
		dfs(1,0,0);
		System.out.println(max);
		
		br.close();
    	return;
    }
}
