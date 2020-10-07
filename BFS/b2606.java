// 2020-10-08 Yoo Jaein
// [BOJ] 2606 바이러스
// BFS

import java.io.*;
import java.util.*;

public class Main {
	
	static Queue<Integer> queue = new LinkedList<>();
	static boolean[] visited; // 컴퓨터의 방문을 체크
	static int[][] arr; // 컴퓨터의 연결을 나타내는 인접 행렬
	static int n;
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			int v = queue.poll();
			
			for(int i=0; i<n; i++) {
				if(arr[v][i]==1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visited = new boolean[n];
		
		for(int i=0; i<k; i++) {
			String[] s = br.readLine().split(" ");
			// 컴퓨터 쌍
			arr[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 1;
			arr[Integer.parseInt(s[1])-1][Integer.parseInt(s[0])-1] = 1;
		}
		
		queue.add(0);
		visited[0] = true;
		bfs();
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(visited[i])
				cnt++;
		}
		System.out.println(cnt-1);
		
		br.close();
    	return;
    }
}