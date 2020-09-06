// 2020-08-14 Yoo Jaein
// [BOJ] 14501 퇴사
// dfs, BackTracking

import java.io.*;
import java.util.*;

public class Main {
	static int[] T;
	static int[] P;
	static int n;
	static int max;
	
	public static void dfs(int v, int sum) {
		if(v >= n) {
			max = Math.max(sum, max);
			return;
		}
		
		// v를 포함
		if(v+T[v] <= n) {
			dfs(v+T[v], sum+P[v]);
		}
		
		// v를 포함하지 않고 다음을 선택
		dfs(v+1, sum);
	}

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	n = Integer.parseInt(br.readLine().toString());
    	T = new int[n];
    	P = new int[n];
    	    	
    	for(int i=0; i<n; i++) {
    		String[] s = br.readLine().split(" ");
    		T[i] = Integer.parseInt(s[0]);
    		P[i] = Integer.parseInt(s[1]);
    	}
    	
    	dfs(0, 0);
    	System.out.println(max);
		br.close();
    	return;
    }
}
