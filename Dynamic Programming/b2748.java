// 2020-09-22 Yoo Jaein
// [BOJ] 2748 피보나치 수 2
// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n+1];
		
		arr[0] = 0;
		arr[1] = 1;
		
		if(n>=2) {
			for(int i=2; i<=n; i++) {
				arr[i] = arr[i-2]+arr[i-1];
			}
		}
		
		System.out.println(arr[n]);
		
		br.close();
    	return;
    }
}
