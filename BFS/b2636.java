// 2020-10-10 Yoo Jaein
// [BOJ] 2636 치즈
// BFS

import java.io.*;
import java.util.*;

public class Main {
	
	private static int n, m;
	private static int[][] map;
	private static boolean[][] visited, bfs_visited;
	
	private static int[] dx = {0, -1, 0, 1};
	private static int[] dy = {1, 0, -1, 0};
	
	
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs() {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0));
		
		while(!queue.isEmpty()) {
			Pair v = queue.poll();
			
			for(int i=0; i<4; i++) {
				int cx = v.x + dx[i];
				int cy = v.y + dy[i];
				
				if(cx<0 || cy<0 || cx>=n || cy>=m) continue;
				
				// 외부 공기를 체크한다
				// 내부 공기와 외부 공기가 연결될 수 있으므로 !=1로 설정한다
				if(!bfs_visited[cx][cy] && map[cx][cy]!=1) {
					bfs_visited[cx][cy] = true;
					queue.add(new Pair(cx, cy));
					map[cx][cy] = -1;
				}
			}
		}
	}
	
	public static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}System.out.println();
	}
	
	public static boolean check() {
		// 치즈가 한 조각이라도 있으면 true, 없으면 false 리턴
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1)
					return true;
			}
		}
		return false;
	}
	
	public static int getCheese() {
		// 전체 map에서 치즈 개수 리턴
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1)
					cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		int time = 0;
		int remain = 0;
		Queue<Pair> meltQueue = new LinkedList<>();
		
		while(true) {
			// 치즈가 남아 있으면
			if(check()) {
				// 배열 초기화
				visited = new boolean[n][m];
				bfs_visited = new boolean[n][m];
				time++;
				remain = getCheese();
				
				// 외부 공기 탐색
				bfs();
				
				// 가장자리 치즈 검사
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {
						
						// 일단 치즈가
						if(map[i][j]==1) {
							for(int k=0; k<4; k++) {
								int cx = i + dx[k];
								int cy = j + dy[k];
								
								if(cx<0 || cy<0 || cx>=n || cy>=m) continue;
								
								// 외부공기(-1)와 닿아있다면 가장자리 치즈이다
								if(!visited[i][j] && map[cx][cy]==-1) {
									// 인덱스 주의!!
									visited[i][j] = true;
									meltQueue.add(new Pair(i, j));
								}
							}
						}
						
					}
				}
				
				// 큐에서 하나씩 꺼내면서 치즈를 녹인다
				while(!meltQueue.isEmpty()) {
					Pair v = meltQueue.poll();
					map[v.x][v.y]= -1;
				}
				
			} else {
				break;
			}
			
		}
		
		System.out.println(time);
		System.out.println(remain);
		
		br.close();
    	return;
    }
}