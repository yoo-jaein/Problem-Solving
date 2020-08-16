// 2020-08-16 Yoo Jaein
// [BOJ] 10845 큐
// Data Structure: queue

import java.io.*;
import java.util.*;

class Queue {
	private ArrayList<Integer> queueArray;
	
	public Queue() {
		this.queueArray = new ArrayList<Integer>();
	}
	
	public void push(int data) {
		this.queueArray.add(data);
	}
	
	public int pop() {
		if(this.empty()==1) return -1;
		
		int data = queueArray.get(0);
		this.queueArray.remove(0);
		return data;
	}
	
	public int size() {
		return queueArray.size();
	}
	
	public int empty() {
		if(this.size()==0) return 1;
		return 0;
	}
	
	public int front() {
		if(this.empty()==1) return -1;
		return this.queueArray.get(0);
	}
	
	public int back() {
		if(this.empty()==1) return -1;
		return this.queueArray.get(queueArray.size()-1);
	}
}


public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	Queue queue = new Queue();
    	
    	int N = Integer.parseInt(br.readLine());
    	for(int i=0; i<N; i++) {
    		String[] s = br.readLine().split(" ");
    		
    		if(s[0].equals("push")) queue.push(Integer.parseInt(s[1]));
    		else if(s[0].equals("pop")) System.out.println(queue.pop());
    		else if(s[0].equals("size")) System.out.println(queue.size());
    		else if(s[0].equals("empty")) System.out.println(queue.empty());
    		else if(s[0].equals("front")) System.out.println(queue.front());
    		else if(s[0].equals("back")) System.out.println(queue.back());
    	}
    	
    	br.close();
    	return;
    }
}
