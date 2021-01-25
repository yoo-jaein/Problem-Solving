// 2021-01-25 Yoo Jaein
// [BOJ] 10833 사과
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			int apple = Integer.parseInt(st.nextToken());
			
			answer += apple % student;
		}
		System.out.println(answer);
		
		br.close();
		return;
	}
}