// 2020-08-16 Yoo Jaein
// [BOJ] 9933 민균이의 비밀번호
// String

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	int N = Integer.parseInt(br.readLine());
    	String[] s = new String[N];
    	for(int i=0; i<N; i++) {
    		s[i] = br.readLine();
    	}
    	
    	outer:
    	for(int i=0; i<N; i++) {
    		String reverse = (new StringBuffer(s[i])).reverse().toString();
    		for(int j=i; j<N; j++) {
    			if(s[j].equals(reverse)) {
    				System.out.println(s[j].length()+" "+s[j].charAt(s[j].length()/2));
    				break outer;
    			}
    		}
    	}
    	
		br.close();
    	return;
    }
}
