// 2020-10-09 Yoo Jaein
// [BOJ] 1926 그림
// BFS

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int n, m;
	
	static int max;
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
		int cnt = 0; // 그림의 넓이 계산
		while(!queue.isEmpty()) {
			Pair v = queue.poll();
			cnt++; // queue에서 하나씩 꺼낼 때 마다 증가
			
			for(int i=0; i<4; i++) {
				int cx = v.x + dx[i];
				int cy = v.y + dy[i];
				
				if(cx<0 || cy<0 || cx>=n || cy>=m) continue;
				
				if(!visited[cx][cy] && map[cx][cy]==1) {
					queue.add(new Pair(cx, cy));
					visited[cx][cy] = true;
				}
			}
		}
		max = Math.max(max, cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int painting = 0; // 그림의 개수
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					visited[i][j] = true;
					queue.add(new Pair(i, j));
					bfs();
					painting++;
					
				}
			}
		}
		
		System.out.println(painting);
		System.out.println(max);
		
		br.close();
    	return;
    }
}