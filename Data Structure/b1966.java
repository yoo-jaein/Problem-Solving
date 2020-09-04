// 2020-09-04 Yoo Jaein
// [BOJ] 1966 프린터 큐
// Data Structure

import java.io.*;
import java.util.*;

public class Main {
	static class Pair {
		int num;
		int w;
		public Pair(int num, int w) {
			this.num = num;
			this.w = w;
		}		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			String[] s = br.readLine().split(" ");
			
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]); // 궁금한 문서의 num
			
			String[] ws = br.readLine().split(" ");
			
			Queue<Pair> queue = new LinkedList<>();
			for(int j=0; j<n; j++) {
				queue.add(new Pair(j, Integer.parseInt(ws[j])));
			}
			
			int answer = 0;
			int cnt = 0;
			
			while(!queue.isEmpty()) {
				int top = queue.peek().w; // 맨 앞의 중요도
				boolean flag = true;
				
				for(Pair p : queue) {
					if(top<p.w) {
						queue.add(new Pair(queue.peek().num, queue.peek().w));
						queue.poll();
						flag = false;
						break;
					}
				}
				
				if(flag) {
					cnt++;
					if(m==queue.peek().num)
						answer = cnt;
					queue.poll();
				}
			}
			
			System.out.println(answer);
			
		}
		
    	return;
    }
}
