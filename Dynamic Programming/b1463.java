// 2020-09-23 Yoo Jaein
// [BOJ] 1463 1로 만들기
// Dynamic Programming

import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1] = 0;
		
		// Bottom-Up 방식
		// 1을 빼는 연산을 가장 먼저해서 최대값을 기억한다
		// 이후 2를 나누는 연산, 3을 나누는 연산으로 최소값을 저장한다
		for(int i=2; i<n+1; i++) {
			dp[i] = dp[i-1]+1;
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		
		System.out.println(dp[n]);
		br.close();
    	return;
    }
}
