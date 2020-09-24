// 2020-09-24 Yoo Jaein
// [BOJ] 2164 카드2
// Data Structure

import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		
		while(queue.size()!=1) {
			queue.poll();
			int top = queue.poll();
			queue.add(top);
		}
		System.out.println(queue.poll());
		
		br.close();
    	return;
    }
}
