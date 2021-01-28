// 2021-01-28 Yoo Jaein
// [BOJ] 10867 중복 빼고 정렬하기
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		// Set -> List
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i : list)
			sb.append(i).append(" ");
		System.out.println(sb.toString());
			
		br.close();
		return;
	}
}