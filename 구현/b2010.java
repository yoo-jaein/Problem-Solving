// 2020-09-05 Yoo Jaein
// [BOJ] 2010 플러그
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			answer += arr[i]-1;
		}
		answer++; // 마지막 콘센트
		System.out.println(answer);
		
    	return;
    }
}
