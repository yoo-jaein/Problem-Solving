// 2020-10-13 Yoo Jaein
// [SWEA] 2117 홈 방범 서비스
// 시뮬레이션

import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	static int[] price;
	static int maxCnt = 0;
	
	public static void solve(int x, int y) {
		int money = 0;
		for(int k=1; k<n+2; k++) {
			int house = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int nx = Math.abs(x-i);
					int ny = Math.abs(y-j);
					
					if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
					
					// 범위 주의!
					// (i,j)부터 중심 (x,y)까지의 거리 nx, ny
					// nx, ny의 합이 k보다 작아야 함
					// k = |nx-x| + |ny-y|
					if(nx+ny<k && map[i][j]==1)
						house++;
				}
			}
			
			money = house*m - price[k];
			if(money>=0) {
				// 서비스 제공이 가능한 집의 최댓값 구하기
				maxCnt = Math.max(maxCnt, house);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		price = new int[n+2];
		for(int k=1; k<n+2; k++) {
			price[k] = k*k + (k-1)*(k-1);
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				solve(i, j);
			}
		}
		
		System.out.println("#"+"test_case"+" "+maxCnt);
		
		sc.close();
		
		br.close();
    	return;
    }
}