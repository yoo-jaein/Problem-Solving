// 2021-01-24 Yoo Jaein
// [BOJ] 2953 나는 요리사다
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int winner = 0;
		int score = 0;
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmp = 0;
			
			for(int j=0; j<4; j++) {
				tmp += Integer.parseInt(st.nextToken());
			}
			if(tmp > score) {
				winner = i+1;
				score = tmp;
			}
		}
		
		System.out.println(winner+" "+score);
		
		br.close();
		return;
	}
}