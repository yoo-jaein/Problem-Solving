// 2020-08-16 Yoo Jaein
// [BOJ] 1152 단어의 개수
// String

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	int answer = 0;
    	String[] s = br.readLine().split(" ");
    	
    	for(int i=0; i<s.length; i++) {
    		if(!s[i].equals(""))
    			answer++;
    	}
    	
    	System.out.println(answer);
		br.close();
    	return;
    }
}
