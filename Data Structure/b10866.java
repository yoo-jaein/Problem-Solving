// 2020-10-29 Yoo Jaein
// [BOJ] 10866 덱
// Data Structure: Deque

import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer> deque = new ArrayList<>();
	
	public static void push_front(int x) {
		// push_front X: 정수 X를 덱의 앞에 넣는다.
		deque.add(0, x);
	}
	
	public static void push_back(int x) {
		// push_back X: 정수 X를 덱의 뒤에 넣는다.
		deque.add(x);
	}
	
	public static void pop_front() {
		// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다.
		// 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if(deque.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(deque.get(0));
			deque.remove(0);
		}
	}
	
	public static void pop_back() {
		// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다.
		// 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if(deque.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(deque.get(deque.size()-1));
			deque.remove(deque.size()-1);
		}
	}
	
	public static void size() {
		// size: 덱에 들어있는 정수의 개수를 출력한다.
		System.out.println(deque.size());
	}
	
	public static void empty() {
		// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
		if(deque.isEmpty()) System.out.println(1);
		else System.out.println(0);
	}
	
	public static void front() {
		// front: 덱의 가장 앞에 있는 정수를 출력한다. 
		// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if(deque.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(deque.get(0));
		}
	}
	
	public static void back() {
		// back: 덱의 가장 뒤에 있는 정수를 출력한다.
		// 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if(deque.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(deque.get(deque.size()-1));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수를 저장하는 덱(Deque) 구현하기
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			if(command.equals("push_front")) {
				int x = Integer.parseInt(st.nextToken());
				push_front(x);
			} else if(command.equals("push_back")) {
				int x = Integer.parseInt(st.nextToken());
				push_back(x);
			} else if(command.equals("pop_front")) {
				pop_front();				
			} else if(command.equals("pop_back")) {
				pop_back();
			} else if(command.equals("size")) {
				size();
			} else if(command.equals("empty")) {
				empty();
			} else if(command.equals("front")) {
				front();
			} else if(command.equals("back")) {
				back();
			}
		}
		
		
		br.close();
		return;
	}
}