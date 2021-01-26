// 2021-01-26 Yoo Jaein
// [BOJ] 10709 기상캐스터
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[][] check = new int[h][w];
		char[][] map = new char[h][w];
		char[][] map2 = new char[h][w];
		
		// 구름 지도 입력
		for(int i=0; i<h; i++) {
			String str = br.readLine();
			
			for(int j=0; j<w; j++) {
				map[i][j] = str.charAt(j);
				map2[i][j] = '.';
				
				if(map[i][j] == 'c') {
					check[i][j] = 0;
				} else {
					check[i][j] = -1;
				}
			}
		}
		
		int time = 1;
		
		// Arrays.equals()는 2차원 배열의 원소들의 번지를 비교함
		// Arrays.deepEquals()는 번지와 상관없이 원소 값들을 비교함
		while(!Arrays.deepEquals(map, map2)) {
			// 모든 구름을 동쪽으로 한 칸 이동
			for(int j=0; j<h; j++) {
				for(int i=w-1; i>0; i--) {
					map[j][i] = map[j][i-1];
				}
				map[j][0] = '.';
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 'c' && check[i][j] == -1) {
						check[i][j] = time;
					}
				}
			}
			time++;
		}
		
		// 최종 출력
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				System.out.print(check[i][j]+" ");
			}
			System.out.println();
		}
		
		br.close();
		return;
	}
}