// 2020-09-21 Yoo Jaein
// [BOJ] 1181 단어 정렬
// 구현

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		// 중복 제거
		HashSet<String> set = new HashSet<String>();
		 
		for(int i=0; i<n; i++) 
		set.add(br.readLine());

		// Set -> ArrayList 변환
		ArrayList<String> list = new ArrayList<>(set);

		// Comparator compare 오버라이드 
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length())
					return s1.compareTo(s2);
				else
					return s1.length()-s2.length();
			}
		});

		// ArrayList 출력
		for(String s : list)
			System.out.println(s);

		br.close();
    	return;
    }
}
