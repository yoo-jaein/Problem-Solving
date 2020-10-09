// 2020-10-09 Yoo Jaein
// [BOJ] 1743 음식물 피하기
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
	
	static int max;
	
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs() {
		int cnt = 0; // 영역의 넓이를 저장
		while(!queue.isEmpty()) {
			Pair v = queue.poll();
			cnt++; // queue에서 하나 꺼낼 때 마다 영역의 넓이 증가
			
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
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r-1][c-1] = 1; // 범위 주의
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					queue.add(new Pair(i, j));
					visited[i][j] = true;
					bfs();
				}
			}
		}
		
		System.out.println(max);
		
		br.close();
    	return;
    }
}