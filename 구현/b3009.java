// 2020-09-05 Yoo Jaein
// [BOJ] 3009 네 번째 점
// 구현

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] dots = new int[3][2];
		for(int i=0; i<3; i++) {
			String[] s = br.readLine().split(" ");
			
			dots[i][0] = Integer.parseInt(s[0]);
			dots[i][1] = Integer.parseInt(s[1]);
		}
		int x = dots[0][0];
		int y = dots[0][1];
		
		if(x==dots[1][0]) 
			x = dots[2][0];
		else if(x==dots[2][0])
			x = dots[1][0];
		
		if(y==dots[1][1]) 
			y = dots[2][1];
		else if(y==dots[2][1])
			y = dots[1][1];
		
		System.out.println(x+" "+y);
		br.close();
    	return;
    }
}
