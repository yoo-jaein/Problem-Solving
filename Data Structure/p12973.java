// 2020-10-28 Yoo Jaein
// [PRG] 12973 짝지어 제거하기
// Data Structure: Stack

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		String s = "bbbaaabbb";
		int answer;
		
		Stack<Character> q = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			if(q.isEmpty()) {
				q.add(s.charAt(i));
				continue;
			}
			else if(q.peek()==s.charAt(i)) {
				q.pop();
			}
			else {
				q.add(s.charAt(i));
			}
		}
		
		if(q.isEmpty()) answer = 1;
		else answer = 0;

		System.out.println(answer);
		
    		return;
	}
}