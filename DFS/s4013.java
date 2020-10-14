// 2020-10-13 Yoo Jaein
// [SWEA] 4013 특이한 자석
// DFS, 시뮬레이션

import java.io.*;
import java.util.*;

public class Main {
	
	static int k;
	static int[][] magnet;
	static int score;
	
	static boolean[] visited;
	
	public static void rotate(int num, int dir) {
		// num번 자석을 dir방향으로 한 번 회전한다
		// 배열을 복사하면서 구현한다, 붙여넣을 때 밀려 쓰지 않도록 주의
		
		// dir==1, 시계방향, lastPoll한 것을 firstAdd함
		if(dir==1) {
			int lastPoll = magnet[num][7];
			
			for(int i=7; i>0; i--) {
				magnet[num][i] = magnet[num][i-1];
			}
			magnet[num][0] = lastPoll;
		}
		// dir==-1, 반시계방향, firstPoll한 것을 lastAdd함
		else if(dir==-1) {
			int firstPoll = magnet[num][0];
			
			for(int i=0; i<7; i++) {
				magnet[num][i] = magnet[num][i+1];
			}
			magnet[num][7] = firstPoll;
		}
	}
	
	public static void dfs(int num, int dir) {
		// num번 자석 dir방향 회전
		visited[num] = true;
		
		if(num+1<=3 && !visited[num+1]) {
			if(magnet[num][2] != magnet[num+1][6])
				dfs(num+1, -1*dir);
		}
		
		if(num-1>=0 && !visited[num-1]) {
			if(magnet[num-1][2] != magnet[num][6])
				dfs(num-1, -1*dir);
		}
		
		rotate(num, dir);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt();
		magnet = new int[4][8];
		for(int i=0; i<4; i++) {
			for(int j=0; j<8; j++) {
				magnet[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<k; i++) {
			visited = new boolean[4];
			
			// 입력값 주의!
			int num = sc.nextInt()-1;
			int dir = sc.nextInt();
			
			dfs(num, dir);
		}
		
		// 점수 계산, S극(1)일때 득점
		if(magnet[0][0]==1) score+=1;
		if(magnet[1][0]==1) score+=2;
		if(magnet[2][0]==1) score+=4;
		if(magnet[3][0]==1) score+=8;
		
		System.out.println("#"+"test_case"+" "+score);
		score = 0;
		
		sc.close();
		
		br.close();
    	return;
    }
}