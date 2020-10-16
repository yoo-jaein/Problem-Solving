// 2020-10-16 Yoo Jaein
// [BOJ] 16236 아기상어
// BFS

import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] map;
	static boolean[][] visited;
	static boolean check = true;
	
	static Info shark;
	static int size, cnt;
	static int ans;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static class Info implements Comparable<Info>{
		int x, y; // 배열 좌표
		int dist;
		
		public Info(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Info o) {
			if(this.dist > o.dist) 
				return 1;
			else if(this.dist < o.dist)
				return -1;
			else {
				// 같을 때!
				if(this.x > o.x) return 1;
				else if(this.x < o.x) return -1;
				else {
					// 같을 때!
					if(this.y > o.y) return 1;
					else if(this.y < o.y) return -1;
				}
			}
			return 0;
		}
		
	}
	
	public static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
	
	public static void bfs() {
		// bfs 탐색용 큐
		Queue<Info> q = new LinkedList<>();
		visited = new boolean[n][n];
		q.add(new Info(shark.x, shark.y, 0));
		
		// 먹을 수 있는 물고기 큐
		PriorityQueue<Info> fish = new PriorityQueue<>();
		
		while(!q.isEmpty()) {
			Info v = q.poll();
			int time = v.dist; // depth에 따라 거리를 갱신한다
			
			for(int i=0; i<4; i++) {
				int cx = v.x + dx[i];
				int cy = v.y + dy[i];
				
				if(cx<0 || cy<0 || cx>=n || cy>=n || visited[cx][cy]) continue;
				if(map[cx][cy]>size) continue; // 아기상어의 크기보다 클 때 못지나감
				
				
				// 지나감
				q.add(new Info(cx, cy, time+1));
				visited[cx][cy] = true;
				
				if(1<=map[cx][cy] && map[cx][cy]<size) {
					// 먹을 수 있는 물고기를 저장
					fish.add(new Info(cx, cy, time+1));
				}
			}
		}
		
		// 더 이상 먹을 수 있는 물고기가 공간에 없다
		if(fish.size()==0) {
			check = false;
			return;
		}
		
		// 물고기 큐를 살핀다	
		ans += fish.peek().dist;
		// 상어를 첫번째 물고기 위치로 옮긴다
		shark.x = fish.peek().x;
		shark.y = fish.peek().y;
		// 맵에서 해당 위치를 0으로 갱신한다
		map[shark.x][shark.y] = 0;
		
		cnt++;
		if(cnt==size) {
			// 아기상어 레벨업
			cnt = 0;
			size++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		
		// 초기 아기상어의 크기는 2
		size = 2;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==9) {
					shark = new Info(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
		
		while(true) {
			bfs();
			if(!check)
				break;
		}
		
		System.out.println(ans);
		
		br.close();
    	return;
    }
}