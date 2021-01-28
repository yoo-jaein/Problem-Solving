// 2020-09-18 Yoo Jaein
// [PRG] 12915 문자열 내 마음대로 정렬하기
// String

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strings = {"sun", "bed", "car"};
		int n = 1;
		
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.charAt(n)>s2.charAt(n)) // 오름차순
					return 1;
                if(s1.charAt(n)==s2.charAt(n)) // 만약 인덱스의 문자가 같으면 
                    return s1.compareTo(s2); // 문자열의 사전순
				return -1;
			}
		});
		
		for(int i=0; i<strings.length; i++)
			System.out.println(strings[i]);
		
		br.close();
		return;
    }
}
