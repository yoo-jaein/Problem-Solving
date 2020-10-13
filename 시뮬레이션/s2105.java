// 2020-10-13 Yoo Jaein
// [SWEA] 2105 디저트 카페
// DFS, 시뮬레이션

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int n;
	static int max;
	
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static HashSet<Integer> set;
	static int start_x, start_y; // 시작 지점을 기억해뒀다가 종료 조건에 사용
	
	public static void dfs(int x, int y, int dir) {
		// 좌표 (x, y)에서 dir 방향으로 탐색 시작
		for(int i=dir; i<4; i++) { // 직진하거나 회전하거나			
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			// visited로 거르기 이전에
			// 시작점에 도달했는지 검사
			if(cx==start_x && cy==start_y && set.size()>=3) {
				max = Math.max(max, set.size());
				return;
			}
			
			if(cx<0 || cy<0 || cx>=n || cy>=n || visited[cx][cy]) continue;
			if(set.contains(map[cx][cy])) continue;
			
			// 백트래킹
			// dir 방향으로 직진하는 경우
			visited[cx][cy] = true;
			set.add(map[cx][cy]);
			dfs(cx, cy, i);
			
			// 복원
			visited[cx][cy] = false;
			set.remove(map[cx][cy]);
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		visited = new boolean[n][n];
		set = new HashSet<>();
		max = -1;
		
		// 사각형이 만들어 질 수 없는 위치 제외함
		for(int i=0; i<n-2; i++) {
			for(int j=1; j<n-1; j++) {
				set.add(map[i][j]);
				start_x = i;
				start_y = j;
				
				visited[i][j] = true;
				dfs(i, j, 0);
				
				// 복원
				visited[i][j] = false;
				set.remove(map[i][j]);
			}
		}
		
		System.out.println("#"+"test_case"+" "+max);
		
		sc.close();
		
		br.close();
    	return;
    }
}