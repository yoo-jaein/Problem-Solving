// 2020-08-16 Yoo Jaein
// [BOJ] 10773 제로
// Data Structure: stack

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	int K = Integer.parseInt(br.readLine());
    	Stack<Integer> stack = new Stack<>();
    	for(int i=0; i<K; i++) {
    		int num = Integer.parseInt(br.readLine());
    		
    		if(num!=0) // 정확한 수
    			stack.push(num);
    		else // 0이면 최근 수 삭제(top 삭제)
    			stack.pop();
    	}
    	
    	int answer = 0;
    	for(int n : stack)
    		answer += n;
    	
    	System.out.println(answer);
		br.close();
    	return;
    }
}
