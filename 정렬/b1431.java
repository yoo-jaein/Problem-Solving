// 2021-01-28 Yoo Jaein
// [BOJ] 1431 시리얼 번호
// 정렬

import java.io.*;
import java.util.*;

public class Main {
	
	public static int sum(String s) {
		int result = 0;
		for(int i=0; i<s.length(); i++) {
			if(Character.isDigit(s.charAt(i)))
				result += Integer.parseInt(s.substring(i, i+1));
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// A-Z, 0-9
		int n = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(br.readLine());
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					if(sum(s1) == sum(s2)) {
						// 길이 같고 합도 같으면 사전 순, 숫자가 알파벳보다 더 작다
						return s1.compareTo(s2);
					}
					// 길이가 같으면 A의 숫자 합과 B의 숫자 합을 비교해서 작은 것 먼저
					return sum(s1) - sum(s2);
				}
				// 짧은 것 먼저
				return s1.length() - s2.length();
			}
		});

		for(String s : list)
			System.out.println(s);
		
		br.close();
		return;
	}
}