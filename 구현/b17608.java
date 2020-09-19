// 2020-09-19 Yoo Jaein
// [BOJ] 17608 막대기
// 구현

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int max = 0;
		int cnt = 0;
		
		// 오른쪽에서 시작, max보다 큰 막대기는 보인다
		// max를 계속 갱신하면서 보이는 막대기 개수 세기
		for(int i=n-1; i>=0; i--) {
		    if(max<arr[i]) {
		      cnt++;
		      max = arr[i];
		    }
		}
		
		System.out.println(cnt);
		br.close();
		return;
    }
}
