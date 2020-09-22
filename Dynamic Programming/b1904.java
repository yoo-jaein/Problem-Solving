// 2020-09-22 Yoo Jaein
// [BOJ] 1904 01타일
// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n+1];
		
		arr[1] = 1;
		
		if(n>=2) {
			arr[2] = 2;
			
			for(int i=3; i<n+1; i++) {
				arr[i] = (arr[i-1]+arr[i-2])%15746;
			}
		}
		System.out.println(arr[n]);
		
		br.close();
    	return;
    }
}
