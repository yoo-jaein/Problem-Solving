// 2021-01-28 Yoo Jaein
// [BOJ] 11728 배열 합치기
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=n; i<n+m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		// 배열 원소 하나씩 println하면 시간 초과됨
		// StringBuilder 사용해서 시간 단축시키기
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n+m; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
		
		br.close();
		return;
	}
}