// 2020-10-13 Yoo Jaein
// [SWEA] 2117 홈 방범 서비스
// BFS

import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	static int[] price;
	static int maxCnt = -999999;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int x, int y) {
		// 좌표 (x, y)를 중심으로 k를 늘려가면서 배열을 탐색하는 bfs
		boolean[][] visited = new boolean[21][21];
		Queue<Pair> q = new LinkedList<>();
		
		visited[x][y] = true;
		q.add(new Pair(x, y));
		
		int size;
		int k = 1;
		
		int house = 0;
		if(map[x][y]==1) house++;
		
		while(!q.isEmpty()) {
			size = q.size();
						
			int money = m*house - price[k];
			if(money>=0) maxCnt = Math.max(maxCnt, house);
			
			if(k==n+1) return;
			
			for(int s=0; s<size; s++) {
				Pair v = q.poll();
				
				for(int t=0; t<4; t++) {
					int nx = v.x + dx[t];
					int ny = v.y + dy[t];
					
					if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
					if(visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					if(map[nx][ny]==1) house++;
					
					q.add(new Pair(nx, ny));
					
				}
			}
			k++;
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		// 배열 크기 넉넉하게 잡기
		map = new int[22][22];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 배열 크기 넉넉하게 잡기
		price = new int[22];
		for(int k=1; k<22; k++) {
			price[k] = k*k + (k-1)*(k-1);
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				bfs(i, j);
			}
		}
		
		System.out.println("#"+"test_case"+" "+maxCnt);
		maxCnt = -999999;
		
		sc.close();
		
		br.close();
    	return;
    }
}