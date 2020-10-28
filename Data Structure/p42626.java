// 2020-10-28 Yoo Jaein
// [PRG] 42626 더 맵게
// Data Structure: PriorityQueue

import java.io.*;
import java.util.*;

public class Main {

	public static boolean check(PriorityQueue<Integer> pq, int K) {
		// 모든 음식의 스코빌 지수가 K 이상인지 확인
		for(Integer i : pq) {
			if(i<K)
				 return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		int answer = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<scoville.length; i++) {
			pq.add(scoville[i]);
		}
		
		while(true) {
			if(check(pq, K)) break;

			// 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우는
			// 음식이 하나 남았는데 그 음식의 스코빌 지수가 K보다 작을 때
			if(pq.size()==1 && pq.peek()<K) {
				answer = -1;
				break;
			}
			
			int A = pq.poll();
			int B = pq.poll();
			int C = A + B * 2;
			
			pq.add(C);
			answer++;
		}
		
		System.out.println(answer);
		
    		return;
	}
}