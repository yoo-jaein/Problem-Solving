// 2020-08-27 Yoo Jaein
// [BOJ] 9095 1, 2, 3 더하기
// Dynamic Programming

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	    	
    	int t = Integer.parseInt(br.readLine());
    	
    	int[] dp = new int[12];
    	
    	dp[0] = 0;
    	dp[1] = 1;
    	dp[2] = 2;
    	dp[3] = 4;
    	
    	for(int i=4; i<12; i++) {
    		dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    	}
    	
    	for(int i=0; i<t; i++) {
    		int n = Integer.parseInt(br.readLine());
    		
    		System.out.println(dp[n]);
    	}
    	
		br.close();
    	return;
    }
}
