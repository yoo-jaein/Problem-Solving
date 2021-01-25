// 2021-01-25 Yoo Jaein
// [BOJ] 11098 첼시를 도와줘!
// String

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		
		for(int i=0; i<n; i++) {
			int p = Integer.parseInt(br.readLine()); // 고려해야될 선수의 수
			int max = 0;
			StringBuilder sb = new StringBuilder();
			
			for(int j=0; j<p; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				
				if(c > max) {
					sb = new StringBuilder(name);
					max = c;
				}
			}
			System.out.println(sb.toString());
		}
		
		br.close();
		return;
	}
}