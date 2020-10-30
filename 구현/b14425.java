// 2020-10-31 Yoo Jaein
// [BOJ] 14425 문자열 집합
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(br.readLine());
		}
		
		for(int i=0; i<m; i++) {
			if(list.contains(br.readLine())) answer++;
		}
		
		System.out.println(answer);
		
		br.close();
		return;
	}
}