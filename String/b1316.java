// 2020-08-18 Yoo Jaein
// [BOJ] 1316 그룹 단어 체커
// String

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	int answer = 0;
    	
    	int N = Integer.parseInt(br.readLine());
    	String[] s = new String[N];
    	for(int i=0; i<N; i++)
    		s[i] = br.readLine();
    	
    	for(int i=0; i<N; i++) {
    		boolean[] check = new boolean[26]; // a~z 체크
    		boolean flag = true;
    		
    		for(int j=0; j<s[i].length(); j++) {
    			char c = s[i].charAt(j); // 현재 가리키는 문자
    			
    			if(!check[c-'a'])
    				check[c-'a'] = true;
    			else {
    				if(s[i].charAt(j-1)==c) // 연속적이면 넘어감
    					continue;
    				else {
    					flag = false;
    					break;
    				}
    			}	
    		}
    		if(flag) answer++;
    	}
    	
    	System.out.println(answer);
    	br.close();
    	return;
    }
}
