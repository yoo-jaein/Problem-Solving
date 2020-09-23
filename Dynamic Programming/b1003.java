// 2020-09-23 Yoo Jaein
// [BOJ] 1003 피보나치 함수
// Dynamic Programming

import java.io.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[41];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;

		for(int i=3; i<41; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());

			if(n==0)
				System.out.println(1+" "+0);
			else if(n==1)
				System.out.println(0+" "+1);
			else
				System.out.println(dp[n-1]+" "+dp[n]);
		}
		br.close();
    	return;
    }
}
