// 2020-10-29 Yoo Jaein
// [BOJ] 2578 빙고
// 시뮬레이션

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	
	public static void remove(int num) {
		// 숫자를 삭제한다
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(map[i][j]==num) {
					map[i][j] = -1;
					return;
				}
			}
		}
	}
	
	public static boolean bingo() {
		// 빙고를 확인한다
		int cnt = 0;
		
		// 가로
		for(int i=0; i<5; i++) {
			int check = 0;
			for(int j=0; j<5; j++) {
				if(map[i][j]==-1) check++;
			}
			if(check==5) cnt++;
		}
		
		// 세로
		for(int j=0; j<5; j++) {
			int check = 0;
			for(int i=0; i<5; i++) {
				if(map[i][j]==-1) check++;
			}
			if(check==5) cnt++;
		}
		
		// 대각선
		int check = 0;
		for(int i=0; i<5; i++) {
			if(map[i][i]==-1) check++;
		}
		if(check==5) cnt++;
		
		check = 0;
		for(int i=0; i<5; i++) {
			if(map[i][4-i]==-1) check++;
		}
		if(check==5) cnt++;
		
		// 3개 이상일 때 빙고
		if(cnt>=3) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		
		map = new int[5][5];
		for(int i=0; i<5; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		outer:
		for(int i=0; i<5; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<5; j++) {
				// 사회자가 부르는 숫자
				int call = Integer.parseInt(s[j]);
				answer++;
				
				// 그 숫자 지우기
				remove(call);
				
				// 빙고 확인
				if(bingo()) {
					System.out.println(answer);
					break outer;
				}
			}
		}
		
		
		br.close();
		return;
	}
}