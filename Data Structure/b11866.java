// 2021-01-24 Yoo Jaein
// [BOJ] 11866 요세푸스 문제 0
// DataStructure: Queue

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt = 1;
		while(!queue.isEmpty()) {
			if(cnt == k) {
				sb.append(queue.poll());
				cnt = 1;
				
				if(!queue.isEmpty())
					sb.append(", ");
			}
			else {
				cnt++;
				queue.add(queue.poll());
			}
		}
		
		sb.append(">");
		
		System.out.println(sb.toString());
		
		br.close();
		return;
	}
}