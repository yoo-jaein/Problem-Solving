// 2020-10-16 Yoo Jaein
// [BOJ] 14500 테트로미노
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[505][505];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				//  ㅁㅁㅁㅁ
				int sum = map[i][j]+map[i][j+1]+map[i][j+2]+map[i][j+3];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁ
				// ㅁ
				// ㅁ
				// ㅁ
				sum = map[i][j]+map[i+1][j]+map[i+2][j]+map[i+3][j];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁㅁ
				// ㅁㅁ
				sum = map[i][j]+map[i][j+1]+map[i+1][j]+map[i+1][j+1];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁㅁㅁ
				//  ㅁ
				sum = map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+1];
				ans = Math.max(sum, ans);
				sum = 0;
				
				//  ㅁ
				// ㅁㅁㅁ
				sum = map[i][j+1]+map[i+1][j]+map[i+1][j+2]+map[i+1][j+1];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁㅁㅁ
				// ㅁ
				sum = map[i][j]+map[i+1][j]+map[i][j+1]+map[i][j+2];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁ
				// ㅁㅁㅁ
				sum = map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+1][j+2];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁ
				// ㅁ
				// ㅁㅁ
				sum = map[i][j]+map[i+1][j]+map[i+2][j]+map[i+2][j+1];
				ans = Math.max(sum, ans);
				sum = 0;
				
				
				//  ㅁ
				//  ㅁ
				// ㅁㅁ
				sum = map[i][j+1]+map[i+1][j+1]+map[i+2][j+1]+map[i+2][j];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁ
				// ㅁㅁ
				// ㅁ
				sum = map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j+1];
				ans = Math.max(sum, ans);
				sum = 0;
				
				//  ㅁ
				// ㅁㅁ
				//  ㅁ
				sum = map[i][j+1]+map[i+1][j]+map[i+1][j+1]+map[i+2][j+1];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁ
				// ㅁㅁ
				//  ㅁ
				sum = map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+2][j+1];
				ans = Math.max(sum, ans);
				sum = 0;
				
				//  ㅁ
				// ㅁㅁ
				// ㅁ
				sum = map[i][j+1]+map[i+1][j+1]+map[i+1][j]+map[i+2][j];
				ans = Math.max(sum, ans);
				sum = 0;
				
				//    ㅁ
				// ㅁㅁㅁ
				sum = map[i+1][j]+map[i+1][j+1]+map[i+1][j+2]+map[i][j+2];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁㅁㅁ
				//    ㅁ
				sum = map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+2];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁㅁ
				// ㅁ
				// ㅁ
				sum = map[i][j]+map[i][j+1]+map[i+1][j]+map[i+2][j];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁㅁ
				//  ㅁ
				//  ㅁ
				sum = map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i+2][j+1];
				ans = Math.max(sum, ans);
				sum = 0;
				
				//   ㅁㅁ
				// ㅁㅁ
				sum = map[i][j+1]+map[i][j+2]+map[i+1][j]+map[i+1][j+1];
				ans = Math.max(sum, ans);
				sum = 0;
				
				// ㅁㅁ
				//   ㅁㅁ
				sum = map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i+1][j+2];
				ans = Math.max(sum, ans);
				sum = 0;
			}
		}
		System.out.println(ans);
		
		br.close();
    	return;
    }
}