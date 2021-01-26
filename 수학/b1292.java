// 2021-01-26 Yoo Jaein
// [BOJ] 1292 쉽게 푸는 문제
// 수학

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] arr = new int[1001];
		
		// 1 2 2 3 3 3 4 4 4 4 5 ...
		for(int idx=1, i=1; idx<=1000; i++) {
			for(int j=0; j<i; j++) {
				if(idx > 1000) break;
				
				arr[idx] = i;
				idx++;
			}
		}
		
		int answer = 0;
		for(int i=a; i<=b; i++)
			answer += arr[i];
		
		System.out.println(answer);
		
		br.close();
		return;
	}
}