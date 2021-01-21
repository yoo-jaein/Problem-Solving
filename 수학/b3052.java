// 2021-01-21 Yoo Jaein
// [BOJ] 3052 나머지
// 수학

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[43];
		int answer = 0;
		
		for(int i=0; i<10; i++) {
			int input = Integer.parseInt(br.readLine());
			
			arr[input % 42]++;			
		}
		
		for(int i=0; i<43; i++) {
			if(arr[i] > 0) {
				answer++;
			}
		}
		
		System.out.println(answer);
		br.close();
		return;
	}
}