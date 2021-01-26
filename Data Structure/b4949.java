// 2021-01-26 Yoo Jaein
// [BOJ] 4949 균형잡힌 세상
// DataStructure: Stack

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		
		while(true) {
			str = br.readLine();
			if(str.equals(".")) {
				break;
			}
			
			Stack<String> stack = new Stack<>();
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) != '(' && str.charAt(i) != ')' && str.charAt(i) != '[' && str.charAt(i) != ']')
					continue;
				
				if(!stack.isEmpty() && stack.peek().equals("(") && str.charAt(i)==')') {
					stack.pop();
					
				} else if(!stack.isEmpty() && stack.peek().equals("[") && str.charAt(i)==']') {
					stack.pop();
					
				}
				else {
					stack.push(str.substring(i, i+1));
				}
				
			}
			
			
			if(stack.isEmpty()) {
				System.out.println("yes");
			} else {
				// System.out.println(stack.toString());
				System.out.println("no");
			}
		}
		
		br.close();
		return;
	}
}