// 2020-09-18 Yoo Jaein
// [PRG] 12917 문자열 내림차순으로 배치하기
// String

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		String s = "Zbcdefg";
		String answer = "";

		// char array로 변환한 뒤 Arrays.sort(str), 기본은 오름차순
		char[] str = s.toCharArray();
		Arrays.sort(str);
		answer = new StringBuilder(new String(str)).reverse().toString();
		
		System.out.println(answer);
		
		return;
    }
}
