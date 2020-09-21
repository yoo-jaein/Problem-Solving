// 2020-09-21 Yoo Jaein
// [PRG] 43165 타겟 넘버
// DFS

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int target;
	static int answer;
	
	public static void dfs(int idx, int num, int[] numbers) {
		if(idx==n) {
			if(num==target) {
				answer++;
			}
			return;
		}
		
		if(idx+1<=n) {
			dfs(idx+1,num+numbers[idx],numbers);
			dfs(idx+1,num-numbers[idx],numbers);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = {1,1,1,1,1};
		n = numbers.length;
		target = 3;
		
		dfs(0,0,numbers);
		System.out.println(answer);
		
		br.close();
    	return;
    }
}
