// 2020-09-24 Yoo Jaein
// [BOJ] 2579 계단 오르기
// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] stair = new int[n+1];
		
		for(int i=1; i<n+1; i++)
			stair[i] = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		dp[1] = stair[1];
		
		if(n>=2)
			dp[2] = stair[1]+stair[2];
		
		if(n>=3)
			dp[3]= Math.max(stair[1]+stair[3], stair[2]+stair[3]);

		// 이전 계단에서 i로 두 칸을 뛰는 경우, 한 칸을 뛰는 경우
		for(int i=4; i<n+1; i++)
			dp[i] = Math.max(dp[i-3]+stair[i]+stair[i-1], dp[i-2]+stair[i]);

		System.out.println(dp[n]);
		br.close();
    	return;
    }
}
