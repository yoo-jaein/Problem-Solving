// 2020-10-06 Yoo Jaein
// [BOJ] 2529 부등호
// BackTracking

import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static char[] arr;
	static int k;
	static long max;
	static long min = Long.MAX_VALUE;

	public static void dfs(ArrayList<Integer> list, int idx) {
		if(list.size()==k+1) {
			StringBuilder sb = new StringBuilder();
			for(int n : list) {
				sb.append(n);
			}
			
			max = Math.max(Long.parseLong(sb.toString()), max);
			min = Math.min(Long.parseLong(sb.toString()), min);
			
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(!visited[i]) {
				if(arr[idx]=='<' && list.get(list.size()-1)<i || arr[idx]=='>' && list.get(list.size()-1)>i) {
					visited[i] = true;
					list.add(i);
					dfs(list, idx+1);
					// list 복원
					list.remove(list.size()-1);
					visited[i] = false; 
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		
		arr = new char[k];
		String[] s2 = br.readLine().split(" ");
		for(int i=0; i<k; i++) {
			arr[i] = s2[i].charAt(0);
		}
		
		visited = new boolean[10];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			visited[i] = true;
			list.add(i);
			dfs(list, 0);
			// list 복원
			list.remove(list.size()-1);
			visited[i] = false;
		}
		
		System.out.println(max);
		
		if(String.valueOf(min).length()<k+1)
			System.out.print(0);
		System.out.println(min);
		
		br.close();
    	return;
    }
}