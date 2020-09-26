// 2020-09-25 Yoo Jaein
// [PRG] 42583 다리를 지나는 트럭
// Data Structure: queue

import java.io.*;
import java.util.*;

public class Main {
	static class Truck {
		int weight;
		int time;
		public Truck(int weight, int time) {
			this.weight = weight;
			this.time = time;
		}
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		
		int answer = 0;
		
		Queue<Truck> queue = new LinkedList<>();
		Queue<Truck> wait = new LinkedList<>();
		
		for(int n : truck_weights) {
			wait.add(new Truck(n,0));
		}
		
		int sum = 0;
		
		while(!wait.isEmpty() || !queue.isEmpty()) {
			answer++;
			
			// 시간 더하고 트럭 제거하기 (queue의 peek만 확인하면 된다)
			if(!queue.isEmpty()) {
				Truck t = queue.peek();
				if(answer-t.time>=bridge_length) {
					sum -= t.weight;
					queue.poll();
				}
			}
			
			// 트럭 올리기 (wait의 peek만 확인하면 된다)
			if(!wait.isEmpty()) {
				Truck t = wait.peek();
				if(sum+t.weight<=weight) {
					wait.poll();
					sum += t.weight;
					queue.add(new Truck(t.weight, answer));
				}
			}
			
		}
		
		System.out.println(answer);

		br.close();
    	return;
    }
}
