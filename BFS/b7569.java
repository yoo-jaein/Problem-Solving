// 2020-10-08 Yoo Jaein
// [BOJ] 7569 토마토
// BFS

import java.io.*;
import java.util.*;

public class Main {
	
	static int m, n, h;
	static int[][][] map;
	static int[][][] visited; // 방문 체크와 Depth 저장
	static int result; // 며칠이 걸리는지 계산, Depth 저장
	
	static int[] dx = {0, -1, 0, 1, 0, 0};
	static int[] dy = {1, 0, -1, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	
	static Queue<Position> queue = new LinkedList<>();
	
	static class Position {
		int x, y, z;
		public Position(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			Position v = queue.poll();
			
			for(int i=0; i<6; i++) {
				int cx = v.x + dx[i];
				int cy = v.y + dy[i];
				int cz = v.z + dz[i];
				
				if(cx<0 || cy<0 || cz<0 || cx>=n || cy>=m || cz>=h) continue;
				
				if(visited[cx][cy][cz]==0 && map[cx][cy][cz]==0) {
					// 안익토를 익토로 만들기
					queue.add(new Position(cx, cy, cz));
					result = visited[cx][cy][cz] = visited[v.x][v.y][v.z]+1;
					map[cx][cy][cz] = 1;
				}
			}
		}
	}
	
	public static void printMap() {
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) 
					System.out.print(map[i][j][k]+" ");
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[n][m][h];
		visited = new int[n][m][h];
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<m; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					
					// 익토는 큐에 넣어서 시간 단축
					if(map[i][j][k]==1) queue.add(new Position(i, j, k));
				}
			}
		}
		
		bfs();
		
		// 안익토가 남아있으면 -1 출력
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int k=0; k<h; k++) {
					if(map[i][j][k]==0) {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		
		System.out.println(result);
		
		br.close();
    	return;
    }
}