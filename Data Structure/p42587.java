// 2020-09-29 Yoo Jaein
// [PRG] 42587 프린터
// Data Structure: queue

import java.io.*;
import java.util.*;

public class Main {

	static class Pair {
		int p;
		int idx;
		public Pair(int p, int idx) {
			this.p = p;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		int cnt = 0;
		int answer = 0;
		
		Queue<Pair> queue = new LinkedList<>();
		
		for(int i=0; i<priorities.length; i++)
			queue.add(new Pair(priorities[i],i));
		
		while(!queue.isEmpty()) {
			// 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
			Pair top = queue.peek();
			
			boolean flag = true;
			
			for(Pair document : queue) {
				// 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
				if(top.p<document.p) {
					queue.add(queue.poll());
					flag = false;
					break;
				}
			}
			
			// 3. 그렇지 않으면 J를 인쇄합니다.			
			if(flag) {
				cnt++;
				queue.poll();
				
				if(location==top.idx)
					answer = cnt;
			}
		}
				
		System.out.println(answer);
		br.close();
    	return;
    }
}