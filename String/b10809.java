// 2020-08-17 Yoo Jaein
// [BOJ] 10809 알파벳 찾기
// String

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	String s = br.readLine();
    	
    	for(char i='a'; i<='z'; i++) {
    		if(s.contains(Character.toString(i)))
    			System.out.print(s.indexOf(i)+" ");
    		else
    			System.out.print("-1 ");
    	}
    	
    	br.close();
    	return;
    }
}
