// 2020-08-16 Yoo Jaein
// [BOJ] 10828 스택
// Data Structure: stack

import java.io.*;
import java.util.ArrayList;

class Stack {
	private ArrayList<Object> stackArray;
	
	public Stack() {
		this.stackArray = new ArrayList<Object>();
	}
	
	public void push(int data) {
		this.stackArray.add(data);
	}
	
	public Object pop() {
		if(this.size()==0) return -1;
		
		Object data = this.stackArray.get(stackArray.size()-1);
		this.stackArray.remove(stackArray.size()-1);
		return data;
	}
	
	public int size() {
		return stackArray.size();
	}
	
	public int empty() {
		if(this.size()==0) return 1;
		return 0;
	}
	
	public Object top() {
		if(this.size()==0) return -1;
		return this.stackArray.get(stackArray.size()-1);
	}
}

public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	Stack stack = new Stack();
    	
    	int N = Integer.parseInt(br.readLine());
    	for(int i=0; i<N; i++) {
    		String[] s = br.readLine().split(" ");
    		
    		if(s[0].equals("push")) stack.push(Integer.parseInt(s[1]));
    		else if(s[0].equals("pop")) System.out.println(stack.pop());
    		else if(s[0].equals("size")) System.out.println(stack.size());
    		else if(s[0].equals("empty")) System.out.println(stack.empty());
    		else if(s[0].equals("top")) System.out.println(stack.top());
    	}
    	
		br.close();
    	return;
    }
}
