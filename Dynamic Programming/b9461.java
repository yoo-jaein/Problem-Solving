// 2020-09-22 Yoo Jaein
// [BOJ] 9461 파도반 수열
// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n+1];
			
			arr[1] = 1;
			
			if(n>=2)
				arr[2] = 1;
			
			if(n>=3)
				arr[3] = 1;
			
			if(n>=4)
				arr[4] = 2;
			
			if(n>=5) {
				for(int i=5, idx=0; i<n+1; i++, idx++) {
					arr[i] = arr[i-1] + arr[idx];
				}
			}
			System.out.println(arr[n]);
		}
		br.close();
    	return;
    }
}
