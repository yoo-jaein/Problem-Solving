// 2020-08-25 Yoo Jaein
// [BOJ] 16234 인구 이동
// DFS
import java.io.*;
import java.util.*;

class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int N, L, R;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	public static int dfs(int x, int y, List<Node> list, int sum) {
		visited[x][y] = true;
		sum = arr[x][y];
		
		for(int i=0; i<4; i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx<0 || cy<0 || cx>=N || cy>=N)
				continue;
			
			if(!visited[cx][cy]){
				int d = Math.abs(arr[x][y]-arr[cx][cy]);
				if(L<=d && d<=R) {
					list.add(new Node(cx,cy));
					sum += dfs(cx,cy,list,sum);
				}
			}
			
		}
		return sum;
	}
	
	
	public static boolean check() {
		List<Node> list;
		boolean isDone = true;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(!visited[i][j]) {
					list = new LinkedList<>();
					list.add(new Node(i,j));
					
					int sum = dfs(i,j,list,0);
					if(list.size()>1) {
						change(sum,list);
						isDone = false;
					}
				}
			}
		}
		return isDone;
	}
	
	
	public static void change(int sum, List<Node> list) {
		int avg = sum/list.size();
		for(Node n:list) 
			arr[n.x][n.y] = avg;
	}
	
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	String[] s = br.readLine().split(" ");
    	N = Integer.parseInt(s[0]);
    	L = Integer.parseInt(s[1]);
    	R = Integer.parseInt(s[2]);
    	arr = new int[N][N];
    	
    	for(int i=0; i<N; i++) {
    		String[] st = br.readLine().split(" ");
    		for(int j=0; j<N; j++) {
    			arr[i][j] = Integer.parseInt(st[j]);
    		}
    	}
    	
    	int answer = 0;
    	
    	while(true) {
    		visited = new boolean[N][N];
    		if(!check())
    			answer++;
    		else
    			break;
    	}
    	
    	System.out.println(answer);
    		
    	br.close();
    	return;
    }
}
