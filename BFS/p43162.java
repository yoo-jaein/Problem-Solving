// 2020-08-28 Yoo Jaein
// [PRG] 43162 네트워크
// DFS/BFS

import java.io.*;
import java.util.*;

public class Main {
	
	static int n = 3;
	static int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0,1,1}};
	static boolean[] visited = new boolean[n];
	
	static int network;
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			
			for(int i=0; i<n; i++) { 
				if(computers[v][i]==1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
    	
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				bfs(i);
				network++;
			}
		}
		
		
		System.out.println(network);
		
    	return;
    }
}
