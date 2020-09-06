// 2020-09-06 Yoo Jaein
// [BOJ] 1759 암호 만들기
// BackTracking

import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static char[] arr;
	
	// i: arr를 가리키는 인덱스, cnt1: 모음 개수, cnt2: 자음 개수, s: 현재 암호
	public static void dfs(int i, int cnt1, int cnt2, String s) {
		if(s.length()==L) {
			if(cnt1>=1 && cnt2>=2)
				System.out.println(s);
			return;
		}
		if(i<arr.length) {
			if(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u') {
				dfs(i+1, cnt1+1, cnt2, s+arr[i]);
			}
			else {
				dfs(i+1, cnt1, cnt2+1, s+arr[i]);
			}
			
			dfs(i+1, cnt1, cnt2, s);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		L = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		
		arr = new char[C];
		s = br.readLine().split(" ");
		for(int i=0; i<C; i++) {
			arr[i] = s[i].charAt(0);
		}
		Arrays.sort(arr);
		
		dfs(0, 0, 0, "");
		
		br.close();
    	return;
    }
}
