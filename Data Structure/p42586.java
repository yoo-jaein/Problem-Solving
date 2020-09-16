// 2020-09-17 Yoo Jaein
// [PRG] 42586 기능개발
// Stack

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=progresses.length-1; i>=0; i--) {
			stack.add(progresses[i]);
		}
		
		while(!stack.isEmpty()) {
			for(int i=0; i<stack.size(); i++) {
				int num = stack.elementAt(i) + speeds[progresses.length-1-i];
				stack.setElementAt(num, i);
			}
			
			int cnt = 0;
			//System.out.println(stack.toString());
			
			while(!stack.isEmpty() && stack.peek()>=100) {
				stack.pop();
				cnt++;
			}
			if(cnt!=0)
				answer.add(cnt);
			
		}
		
		System.out.println(answer.toString());
		
		br.close();
		return;
    }
}
