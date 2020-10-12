// 2020-10-12 Yoo Jaein
// [SWEA] 5656 벽돌 깨기
// BFS, DFS, 시뮬레이션

import java.io.*;
import java.util.*;

public class Main {
	
	static int n, w, h;
	static int remain = Integer.MAX_VALUE;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void go(int[][] map, int cnt, int blocks) {
		// 구슬을 떨어트림, 백트래킹으로 모든 경우의 수를 탐색
		// 종료 조건 1) cnt가 n에 도달할 때
		if(cnt>=n) {
			remain = Math.min(remain, blocks);
			return;
		}
		
		// 종료 조건 2) 부술 벽돌이 없을 때
		boolean allBroken = true;
		
		for(int j=0; j<w; j++) {
			for(int i=0; i<h; i++) {
				if(map[i][j]!=0) {
					allBroken = false;
					
					int num = map[i][j];
					
					if(num==1) {
						// !부순다 (0)
						map[i][j] = 0;
						// !부순다
						
						// 재귀
						go(map, cnt+1, blocks-1);
						
						// 원상복구한다
						map[i][j] = num;
						
					} else {
						// 1이 아니면 연쇄반응 일어남->bfs로 구현
						// 배열을 원상복구하기 힘들다
						// 따라서 배열 전체를 복사해두고 붙여넣기하여 복구시킨다
						int[][] map2 = new int[h][w];
						for(int row=0; row<h; row++) {
							for(int col=0; col<w; col++) {
								map2[row][col] = map[row][col];
							}
						}
						
						// !부순다->bfs
						int b = bfs(map2, i, j);
						
						// 부순 뒤에 중력 적용
						gravity(map2);
						// !부순다
						
						// 재귀
						go(map2, cnt+1, b);
						
					}
					break; // 각 컬럼의 맨 상단만 접근 가능하다
				}
			}
		}
		
		if(allBroken) {
			remain = Math.min(remain, blocks);
		}
		return;
	}
	
	public static void gravity(int[][] map) {
		// 맵에 중력을 적용하여 0인 부분을 지운다
		// stack 사용
		for(int j=0; j<w; j++) {
			Stack<Integer> s = new Stack<>();
			for(int i=0; i<h; i++) {
				if(map[i][j]!=0) {
					s.push(map[i][j]);
					map[i][j] = 0;
				}
			}
			
			int hh = h;
			// 밑바닥부터 stack에서 pop한 것을 입력
			while(!s.isEmpty()) {
				map[hh-- -1][j] = s.pop();
			}
			
		}
	}
	
	public static int bfs(int[][] map, int i, int j) {
		// i, j 위치의 벽돌을 제거
		// map[i][j]-1만큼 상하좌우 벽돌까지 함께 제거한다
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(i, j));
		
		while(!q.isEmpty()) {
			Pair v = q.remove();
			int num = map[v.x][v.y];
			map[v.x][v.y] = 0; // 파괴
			
			// 곱을 하기 때문에 1부터 시작
			for(int idx=1; idx<num; idx++) {
				for(int k=0; k<4; k++) {
					// 4방 탐색
					int cx = v.x + dx[k]*idx;
					int cy = v.y + dy[k]*idx;
					
					if(cx<0 || cy<0 || cx>=h || cy>=w) continue;
					
					// 0이 아니면 삭제 대상이니까 큐에 넣는다
					if(map[cx][cy]!=0) {
						q.add(new Pair(cx, cy));
					}
					
				}
			}
		}
		
		// 제거하고 남은 벽돌의 수 리턴
		int blocks = 0;
		for(int ii=0; ii<h; ii++) {
			for(int jj=0; jj<w; jj++) {
				if(map[ii][jj]!=0)
					blocks++;
			}
		}
		return blocks;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		
		int[][] map = new int[h][w];
		int blocks = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]!=0)
					blocks++;
			}
		}
		
		go(map, 0, blocks);
		
		System.out.println("#"+"test_case"+" "+remain);
		remain = Integer.MAX_VALUE;
		
		br.close();
    	return;
    }
}