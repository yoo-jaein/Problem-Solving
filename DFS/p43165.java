// 2020-08-28 Yoo Jaein
// [PRG] 43165 타겟 넘버
// DFS/BFS

import java.io.*;
import java.util.*;

public class Main {
	
	static int[] numbers = {1, 1, 1, 1, 1};
	static int target = 3;
	static int answer = 0;
	
	public static int dfs(int prev, int index) {
		if(index>=numbers.length) {
			if(target == prev)
				return 1;
			return 0;
		}
		int num = prev+numbers[index];
		int num2 = prev-numbers[index];
		
		int answer = 0;
		answer += dfs(num, index+1);
		answer += dfs(num2, index+1);
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
    	
		int answer = 0;
		answer += dfs(numbers[0],0);
		answer += dfs(-numbers[0],0);
		
		System.out.println(answer);
    	return;
    }
}
