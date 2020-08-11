// 2020-08-11 Yoo Jaein
// [BOJ] 8958 OX퀴즈
// String

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<T; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), "X");
    		
    		int answer = 0;
    		while(st.hasMoreTokens()) {
    			String s = st.nextToken();
    			
    			int n = s.length();
    			answer += n*(n+1)/2;
    		}
    		
    		System.out.println(answer);
    	}
    	
    	return;
    }
}
