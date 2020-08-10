// 2020-08-10 Yoo Jaein
// [BOJ] 11724 연결 요소의 개수
// DFS

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> a;
	static boolean[] visited;
	static int N, M;
	static int cnt = 0;
	
	public static void dfs(int v) {		
		visited[v] = true;
		
		for(int t : a.get(v)) {
			if(!visited[t])
				dfs(t);
		}
	}
	
	public static void dfsAll() {
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
		cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N+1];
		
		a = new ArrayList<>();
		for(int i=0; i<=N; i++)
			a.add(new ArrayList<>());
		
		for(int j=0; j<M; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a.get(u).add(v);
			a.get(v).add(u);
		}

    	dfsAll();
    	System.out.println(cnt);
		
    	return;
    }
}
