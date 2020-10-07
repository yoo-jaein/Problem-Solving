// 2020-10-07 Yoo Jaein
// [BOJ] 15658 연산자 끼워넣기 (2)
// Brute Force

import java.io.*;

public class Main {

	static int n;
	static int[] arr;
	
	static int min = 1000000000;
	static int max = -1000000000;
	
	public static void dfs(int plus, int minus, int mult, int div, int idx, int result) {
		if(idx==n) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		
		if(plus>0)
			dfs(plus-1, minus, mult, div, idx+1, result + arr[idx]);
				
		if(minus>0)
			dfs(plus, minus-1, mult, div, idx+1, result - arr[idx]);
		
		if(mult>0)
			dfs(plus, minus, mult-1, div, idx+1, result * arr[idx]);
		
		if(div>0)
			dfs(plus, minus, mult, div-1, idx+1, result / arr[idx]);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		String[] s = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		// +, -, *, /
		String[] s2 = br.readLine().split(" ");

		int plus = Integer.parseInt(s2[0]);
		int minus = Integer.parseInt(s2[1]);
		int mult = Integer.parseInt(s2[2]);
		int div = Integer.parseInt(s2[3]);
		
		dfs(plus, minus, mult, div, 1, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
		
		br.close();
    	return;
    }
}