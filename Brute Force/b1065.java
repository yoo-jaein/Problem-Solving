// 2020-08-05 Yoo Jaein
// [BOJ] 1065 한수
// Brute Force

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	int answer = 0;
    	
    	if(N<100) {
    		System.out.println(N);
    		return;
    	}
    	
    	for(int i=100; i<=N; i++) {
    		int num = i%10 - i/10%10;
    		int num2 = i/10%10 - i/100%10;
    		
    		if(num==num2)
    			answer++;
    	}
    	if(N==1000) answer--;
    	
    	System.out.println(99+answer);
    	
    	return;
    	
    }
}
