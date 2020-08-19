// 2020-08-19 Yoo Jaein
// [BOJ] 14889 스타트와 링크
// BackTracking

import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[] visited;
	static int[][] s;
	static int min;
	
	public static void comb(int[] arr, int start, int n, int r) {
		if(r==0) { // 종료조건은 N/2개 모았을 때
			ArrayList<Integer> listS = new ArrayList<>();
			ArrayList<Integer> listL = new ArrayList<>();
			
			for(int i=0; i<arr.length; i++) {
				if(visited[i])
					listS.add(arr[i]);
				else
					listL.add(arr[i]);
			}
			
			int sumS = 0;
			for(int i=0; i<listS.size(); i++) {
				for(int j=i+1; j<listS.size(); j++) {
					sumS += s[listS.get(i)][listS.get(j)];
					sumS += s[listS.get(j)][listS.get(i)];
				}
			}
			
			int sumL = 0;
			for(int i=0; i<listL.size(); i++) {
				for(int j=i+1; j<listL.size(); j++) {
					sumL += s[listL.get(i)][listL.get(j)];
					sumL += s[listL.get(j)][listL.get(i)];
				}
			}
			
			
			if(Math.abs(sumS-sumL)<min)
				min = Math.abs(sumS-sumL);
			
			return;
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			comb(arr, i+1, n, r-1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	min = 9999;
    	
    	int N = Integer.parseInt(br.readLine()); // 항상 짝수
    	s = new int[N+1][N+1];
    	for(int i=1; i<N+1; i++) {
    		String str = br.readLine();
    		StringTokenizer st = new StringTokenizer(str, " ");
    		
    		int j=1;
    		while(st.hasMoreTokens()) {
    			s[i][j] = Integer.parseInt(st.nextToken());
    			j++;
    		}
    	}
    	
    	visited = new boolean[N];
    	    	
    	int[] arr = new int[N];
    	for(int i=0; i<N; i++) {
    		arr[i] = i+1;
    	}
    	
    	// N+1개 스타트팀, N+1개 링크팀으로 뽑는다 (조합->백트래킹)
    	comb(arr, 0, N, N/2);
    	
    	System.out.println(min);
    	
    	br.close();
    	return;
    }
}
