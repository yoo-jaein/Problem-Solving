// 2020-10-17 Yoo Jaein
// [BOJ] 17144 미세먼지 안녕!
// 시뮬레이션

import java.io.*;
import java.util.*;

public class Main {
	static int r, c, t;
	static int[][] map;
	static int top, bottom;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0}; 
	
	static class Dust {
		int r, c;
		int dust;
		public Dust(int r, int c, int dust) {
			this.r = r;
			this.c = c;
			this.dust = dust;
		}
	}
	
	// 주의! 모든 먼지가 "동시에" 확산한다
	// 따라서 확산된 먼지는 모든 칸에서 계산이 끝난 뒤 적용되어야 한다.
	public static void spread() {
		Queue<Dust> q = new LinkedList<>();
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				// 미먼
				if(map[i][j]>=5) {
					q.add(new Dust(i, j, map[i][j]));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Dust d = q.poll();
			int cnt = 0; // 확산 가능한 방향의 개수
			int amount = d.dust/5;
			
			for(int i=0; i<4; i++) {
				int cr = d.r + dx[i];
				int cc = d.c + dy[i];
				
				if(cr<0 || cc<0 || cr>=r || cc>=c) continue;
				
				if(map[cr][cc]!=-1) {
					cnt++;
					map[cr][cc] += amount;
				}
			}
			map[d.r][d.c] = map[d.r][d.c] - amount*cnt; 
		}
		
	}
	
	public static void print() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) 
				System.out.print(map[i][j]+" ");
			 System.out.println();
		}
	}
	
	public static void running() {
		// top 위쪽 공기청정기 바람의 순환
		// 삭제되는 부분부터 제거해야 밀리지 않음

		// 아래로
		for(int i=top-1; i>=1; i--)
			map[i][0] = map[i-1][0];
		// 왼쪽으로
		for(int i=0; i<c-1; i++)
			map[0][i] = map[0][i+1];
		// 위로
		for(int i=0; i<top; i++)
			map[i][c-1] = map[i+1][c-1];
		// 오른쪽으로
		for(int i=c-1; i>=1; i--)
			map[top][i] = map[top][i-1];
		
		// bottom 아래쪽 공기청정기 바람의 순환
		// 위로
		for(int i=bottom+1; i<r-1; i++)
			map[i][0] = map[i+1][0];
		// 오른쪽으로
		for(int i=0; i<c-1; i++)
			map[r-1][i] = map[r-1][i+1];
		// 아래로
		for(int i=r-1; i>bottom; i--)
			map[i][c-1] = map[i-1][c-1];
		// 왼쪽으로
		for(int i=c-1; i>=1; i--)
			map[bottom][i] = map[bottom][i-1];
		
		map[top][1] = 0;
		map[bottom][1] = 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		t = sc.nextInt();
		
		int time = 0;
		
		map = new int[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<r; i++) {
			if(map[i][0]==-1) {
				top = i;
				bottom = i+1;
				break;
			}
		}
		
		while(time<t) {
			// 미먼 확산
			spread();
			
			// 공기청정기 작동
			running();
			//print();
			time++;
		}
		
		int ans = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]!=-1)
					ans += map[i][j];
			}
		}
		System.out.println(ans);
		
		sc.close();
		br.close();
    	return;
    }
}