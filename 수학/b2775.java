// 2021-01-23 Yoo Jaein
// [BOJ] 2775 부녀회장이 될테야
// 수학

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] apt = new int[15][15];
		for(int i=0; i<15; i++) {
			apt[i][1] = 1;
			apt[0][i] = i;
		}
		
		for(int i=1; i<15; i++) {
			for(int j=2; j<15; j++) {
				apt[i][j] = apt[i][j-1] + apt[i-1][j];
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// a층 b호
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			
			System.out.println(apt[a][b]);
		}
		
		br.close();
		return;
	}
}