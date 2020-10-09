// 2020-10-09 Yoo Jaein
// [BOJ] 13565 침투
// BFS

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int n, m;
	
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
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			Pair v = queue.poll();
			
			for(int i=0; i<4; i++) {
				int cx = v.x + dx[i];
				int cy = v.y + dy[i];
				
				if(cx<0 || cy<0 || cx>=n || cy>=m) continue;
				
				if(!visited[cx][cy] && map[cx][cy]==0) {
					queue.add(new Pair(cx, cy));
					visited[cx][cy] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		// outer에서 전류를 공급
		for(int i=0; i<m; i++) {
			if(map[0][i]==0 && !visited[0][i]) {
				queue.add(new Pair(0, i));
				visited[0][i] = true;
				bfs();
			}
		}
		
		// inner에 전류가 통하는지 확인
		boolean check = false;
		for(int i=0; i<m; i++) {
			if(visited[n-1][i]) {
				check = true;
			}
		}
		
		if(check) System.out.println("YES");
		else System.out.println("NO");
		
		br.close();
    	return;
    }
}