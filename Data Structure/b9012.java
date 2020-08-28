// 2020-08-27 Yoo Jaein
// [BOJ] 9012 괄호
// Data Structure

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	    	
    	int n = Integer.parseInt(br.readLine());
    	Stack<Character> stack = new Stack<>();
    	
    	for(int i=0; i<n; i++) {
    		String s = br.readLine();
    		
    		for(int j=0; j<s.length(); j++) {
    			// 스택이 비어있으면 그냥 넣는다.
    			if(stack.isEmpty())
    				stack.add(s.charAt(j));
    			else {
    				// 비어있지 않다면 맨 위의 문자를 확인한다.
    				char c = stack.peek();
    				
    				if(c=='(' && s.charAt(j)==')')
    					stack.pop();
    				else
    					stack.add(s.charAt(j));
    			}
    		}
    		System.out.println(stack.isEmpty()?"YES":"NO");
    		
    		// 스택 초기화
    		stack.clear();
    	}
    	
		br.close();
    	return;
    }
}
