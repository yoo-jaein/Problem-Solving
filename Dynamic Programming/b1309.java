// 2020-10-02 Yoo Jaein
// [BOJ] 1309 동물원
// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		dp[1] = 3;
		if(n>1)
			dp[2] = 7;
		
		for(int i=3; i<=n; i++) {
			dp[i] = (2*dp[i-1]+dp[i-2])%9901;
		}
		
		System.out.println(dp[n]);
		
		br.close();
    	return;
    }
}