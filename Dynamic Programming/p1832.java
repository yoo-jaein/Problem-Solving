// 2020-08-14 Yoo Jaein
// [PRG] 1832 보행자 천국
// 2017 카카오코드 예선
// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {	
    	int m = 3;
    	int n = 6;
    	int[][] cityMap = {{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}};
    	int answer = 0;
    	
    	// Dynamic Programming
    	// 자유 통행일때
    	// dp[i][j] = dp[i][j-1] + dp[i-1][j];
    	// (0,0)에서 (i,j)까지 이동 가능한 경로 수는 한 칸 위 좌표까지 이동 가능한 경로 수+한 칸 왼쪽 좌표까지 이동 가능한 경로 수
    	
    	// 금지일때
    	// dp[i][j] = 0;
    	
    	// 무조건 오던 방향으로 직진
    	// 여기서 오던 방향을 어떻게 알아낼 것인가?
    	// 애초에 자료구조를 방향으로 쪼개면 된다. V H
    	
    	// H[i][j]: (i,j)에서 오른쪽으로 갈 수 있는 경우의 수
    	// V[i][j]: (i,j)에서 아래쪽으로 갈 수 있는 경우의 수
    	// (i, j)까지 이동 가능한 경로 수는 H[i][j-1] + V[i-1][j]
    	
    	// 첫 위치 설정
    	// dp[1][1] = 1 + 1;
    	// H[1][1] = V[1][1] = 1;
    	
    	int MOD = 20170805;
    	int[][] H = new int[m+1][n+1];
    	int[][] V = new int[m+1][n+1];
    	
    	H[1][1] = V[1][1] = 1;
    	
    	for(int i=1; i<=m; i++) {
    		for(int j=1; j<=n; j++) {
    			if(cityMap[i-1][j-1]==0) {
    				// 자유 통행
    				H[i][j] = (H[i][j] + H[i][j-1] + V[i-1][j])%MOD;
    				V[i][j] = (V[i][j] + H[i][j-1] + V[i-1][j])%MOD;
    			} else if(cityMap[i-1][j-1]==1) { 
    				// 통행 금지
    				H[i][j] = V[i][j] = 0;
    			} else {
    				// 무조건 오던 방향으로 직진
    				H[i][j] = H[i][j-1];
    				V[i][j] = V[i-1][j];
    			}
    		}
    	}
    	
    	System.out.println((H[m][n-1]+V[m-1][n])%MOD);
    	
    	return;
    }
}
