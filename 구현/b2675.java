// 2020-08-17 Yoo Jaein
// [BOJ] 2675 문자열 반복
// 구현

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int i=0; i<T; i++) {
    		String[] s = br.readLine().split(" ");
    		int R = Integer.parseInt(s[0]);
    		
    		String answer = "";
    		for(int j=0; j<s[1].length(); j++) {
    			for(int k=0; k<R; k++) {
    				answer += s[1].charAt(j);
    			}
    		}
    		System.out.println(answer);
    	}
    	
    	br.close();
    	return;
    }
}
