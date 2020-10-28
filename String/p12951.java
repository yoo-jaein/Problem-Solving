// 2020-10-28 Yoo Jaein
// [PRG] 12951 JadenCase 문자열 만들기
// String

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		String s = "for 3people unFollowed me";
		StringBuilder sb = new StringBuilder();
		
		// 0번째 문자
		if(Character.isLowerCase(s.charAt(0)))
			sb.append(Character.toUpperCase(s.charAt(0)));
		else
			sb.append(s.charAt(0));
		
		for(int i=1; i<s.length(); i++) {
			// 단어의 시작일 때
			if(s.charAt(i-1)==' ')
				sb.append(Character.toUpperCase(s.charAt(i)));
			else
				sb.append(Character.toLowerCase(s.charAt(i)));
		}
		System.out.println(sb.toString());
		
    	return;
    }
}