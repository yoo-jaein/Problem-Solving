// 2020-09-18 Yoo Jaein
// [PRG] 12918 문자열 다루기 기본
// String

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = "a234";
		for(int i=0; i<s.length(); i++) {
			if(Character.isDigit(s.charAt(i)))
				continue;
			else {
				System.out.println("False");
				return;
			}
		}
		
		System.out.println("True");
		
		br.close();
		return;
    }
}
