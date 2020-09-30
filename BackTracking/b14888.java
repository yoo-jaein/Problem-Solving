// 2020-09-30 Yoo Jaein
// [BOJ] 14888 연산자 끼워넣기
// Back Tracking

import java.io.*;
import java.util.*;

public class Main {
	static int min = 1000000001;
	static int max = -1000000001;
	
	static int[] num;
	static int n;
	
	public static void dfs(int plus, int minus, int mul, int div, int cnt, int result) {
		if(cnt==n) {
			min = Math.min(result, min);
			max = Math.max(result, max);
			return;
		}
		
		if(plus>0) {
			int temp = result+num[cnt];
			dfs(plus-1,minus,mul,div,cnt+1,temp);
		}
		
		if(minus>0) {
			int temp = result-num[cnt];
			dfs(plus,minus-1,mul,div,cnt+1,temp);
		}
		
		if(mul>0) {
			int temp = result*num[cnt];
			dfs(plus,minus,mul-1,div,cnt+1,temp);
		}
		
		if(div>0) {
			int temp = result/num[cnt];
			dfs(plus,minus,mul,div-1,cnt+1,temp);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		String[] s = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(s[i]);
		}
		
		String[] s2 = br.readLine().split(" ");
		int plus = Integer.parseInt(s2[0]);
		int minus = Integer.parseInt(s2[1]);
		int mul = Integer.parseInt(s2[2]);
		int div = Integer.parseInt(s2[3]);
		
		dfs(plus,minus,mul,div,1,num[0]);
		
		System.out.println(max);
		System.out.println(min);
		br.close();
    	return;
    }
}