// 2020-10-08 Yoo Jaein
// [BOJ] 2644 촌수계산
// BFS

import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] arr; // 관계를 나타내는 인접 행렬
	static int[] visited; // 방문을 체크하고 깊이를 저장하는 배열
	static int n;
	static int a, b; // 친척 관계를 계산할 번호
	
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			int v = queue.poll();
			
			if(v==b-1) {
				return;
			}
			
			for(int i=0; i<n; i++) {
				if(arr[v][i]==1 && visited[i]==0) {
					visited[i] = visited[v]+1;
					queue.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		
		a = Integer.parseInt(s[0]);
		b = Integer.parseInt(s[1]);
		
		int m = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visited = new int[n];
		
		for(int i=0; i<m; i++) {
			String[] s2 = br.readLine().split(" ");
			// 부모-자식 관계 쌍
			arr[Integer.parseInt(s2[0])-1][Integer.parseInt(s2[1])-1] = 1;
			arr[Integer.parseInt(s2[1])-1][Integer.parseInt(s2[0])-1] = 1;
		}
		
		queue.add(a-1);
		visited[a-1] = 0;
		bfs();
		
		if(visited[b-1]==0) System.out.println("-1");
		else System.out.println(visited[b-1]);
		
		br.close();
    	return;
    }
}