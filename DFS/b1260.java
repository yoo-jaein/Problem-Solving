// 2020-08-10 Yoo Jaein
// [BOJ] 1260 DFS와 BFS
// DFS BFS

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> adj;
	static boolean[] visited;
	
	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		
		for(int t : adj.get(v)) {
			if(!visited[t])
				dfs(t);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		System.out.print(start+" ");
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int t : adj.get(now)) {
				if(!visited[t]) {
					q.offer(t);
					visited[t] = true;
					System.out.print(t+" ");
				}
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int V = Integer.parseInt(s[2]);
		
		adj = new ArrayList<>();
		for(int i=0; i<=N; i++)
			adj.add(new ArrayList<>());
		
		// default: false, 인덱스 편의상 0번째 요소는 쓰지 않음
		visited = new boolean[N+1]; 
		
		for(int i=0; i<M; i++) {
			String[] s2 = br.readLine().split(" ");
			int n1 = Integer.parseInt(s2[0]); // 정점1
			int n2 = Integer.parseInt(s2[1]); // 정점2
			
			// 양방향
			adj.get(n1).add(n2);
			adj.get(n2).add(n1); 
						
			// 정렬하여 정점 번호가 작은 것을 먼저 방문
			Collections.sort(adj.get(n1));
			Collections.sort(adj.get(n2)); 
		}
		
		dfs(V);
		System.out.println();
		
		for(int i=0; i<=N; i++)
			visited[i] = false;
		
		bfs(V);
		
    	return;
    }
}
