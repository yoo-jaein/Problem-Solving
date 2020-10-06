// 2020-10-06 Yoo Jaein
// [BOJ] 10819 차이를 최대로
// BackTracking

import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static boolean[] visited;
	static int n;
	static int max;
	
	public static void dfs(ArrayList<Integer> list) {
		if(list.size()==n) {
			int sum = 0;
			
			for(int i=0; i<n-1; i++) {
				sum += Math.abs(list.get(i)-list.get(i+1));
			}
			max = Math.max(sum, max);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				list.add(arr[i]);
				dfs(list);
				// list 복원
				list.remove(list.size()-1);
				visited[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		String[] s2 = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(s2[i]);
		}
		
		visited = new boolean[n];
		ArrayList<Integer> list = new ArrayList<>();
		
		dfs(list);
		System.out.println(max);
		
		br.close();
    	return;
    }
}