// 2020-10-15 Yoo Jaein
// [BOJ] 15686 치킨 배달
// BackTracking

import java.io.*;
import java.util.*;

public class Main {
	static int ans;
	static int n, m;
	static int[][] map;
	static ArrayList<Pair> house = new ArrayList<>();
	static ArrayList<Pair> chicken = new ArrayList<>();
	static boolean[] visited;
	static int c;
	
	static class Pair {
		int x, y;
		int dist;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Pair(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void dfs(int idx, int cnt) {
		if(cnt==m) {
			// 도시의 치킨 거리 계산
			int result = 0;
			for(Pair p : house) {
				int dist = 999999;
				
				for(int i=0; i<c; i++) {
					if(visited[i])
						dist = Math.min(dist, Math.abs(p.x-chicken.get(i).x) + Math.abs(p.y-chicken.get(i).y));
				}
				result += dist;
			}
			
			ans = Math.min(ans, result);
			return;
		}

		for(int i=idx; i<c; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cnt+1);
				// 복원
				visited[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // n*n 맵
		m = sc.nextInt(); // 최대 m개 치킨집을 고름, 도시 치킨 거리의 최솟값 구하기
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j]==1) {
					house.add(new Pair(i, j));
				} else if(map[i][j]==2) {
					chicken.add(new Pair(i, j));
				}
			}
		}
		
		// 치킨집 개수
		c = chicken.size();
		visited = new boolean[c];
		
		// 각 집의 치킨거리 구하기
		for(Pair p : house) {
			int x = p.x;
			int y = p.y;
			int dist = 999999;
			
			for(Pair c : chicken) {
				dist = Math.min(dist, Math.abs(x-c.x) + Math.abs(y-c.y));
			}
			p.dist = dist;
		}
		
		ans = 999999;
		
		// 전체 치킨집 중에 c-m개 반드시 폐업한다
		// c-m+1개 ... 폐업시킬 수도 있다
		// 종료 시점에서 도시의 치킨거리를 계산한다
		// ans 최솟값을 갱신한다
		dfs(0, 0);
		
		System.out.println(ans);
		
		br.close();
    	return;
    }
}