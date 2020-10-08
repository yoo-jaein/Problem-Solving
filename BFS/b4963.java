// 2020-10-08 Yoo Jaein
// [BOJ] 4963 섬의 개수
// BFS

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static int[][] visited;
	static int w, h;
	
	static Queue<Pair> queue = new LinkedList<>();
	
	static int[] dx = {0, -1, 0, 1, 1, -1, 1, -1};
	static int[] dy = {1, 0, -1, 0, 1, -1 ,-1 ,1};
	
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
			
			for(int i=0; i<8; i++) {
				int cx = v.x + dx[i];
				int cy = v.y + dy[i];
				
				if(cx<0 || cy<0 || cx>=h || cy>=w) continue;
				
				if(map[cx][cy]==1 && visited[cx][cy]==0) {
					queue.add(new Pair(cx, cy));
					visited[cx][cy] = visited[v.x][v.y]+1;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			map = new int[h][w];
			visited = new int[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]==1 && visited[i][j]==0) {
						queue.add(new Pair(i,j));
						bfs();
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
		
		br.close();
    	return;
    }
}