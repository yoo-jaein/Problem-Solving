// 2020-08-22 Yoo Jaein
// [BOJ] 2468 안전 영역
// DFS
import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] arr;
	static boolean[][] visited;
	
	static int cnt;
	static int answer;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int N;
	
	static int min;
	static int max;
	
	public static void dfs(int height, int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			
			if(cx>=0 && cy>=0 && cx<N && cy<N) {
				if(!visited[cx][cy] && arr[cx][cy]>height) {
					dfs(height, cx, cy);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	N = Integer.parseInt(br.readLine());
    	arr = new int[N][N];
    	
    	min = 101; max = 0;
    	
    	for(int i=0; i<N; i++) {
    		String[] s = br.readLine().split(" ");
    		for(int j=0; j<N; j++) {
    			arr[i][j] = Integer.parseInt(s[j]);
    			
    			if(arr[i][j]<min)
    				min = arr[i][j];
    			else if(arr[i][j]>max)
    				max = arr[i][j];
    		}
    	}
    	
    	visited = new boolean[N][N];
    	
    	for(int h=min; h<=max; h++) {
			// 2차원 배열에서의 Arrays.fill
    		for(boolean[] row: visited)
    			Arrays.fill(row, false);

	    	for(int i=0; i<N; i++) {
	    		for(int j=0; j<N; j++) {
	    			if(!visited[i][j] && arr[i][j]>h) {
	    				dfs(h, i, j);
	    				cnt++;
	    			}
	    		}
	    	}
	    	if(cnt>answer) answer = cnt;
	    	cnt = 0;
    	}
    	
    	if(answer==0) // 아무 지역도 물에 잠기지 않을 경우
    		answer++;
    	
    	System.out.println(answer);	
    	
    	br.close();
    	return;
    }
}
