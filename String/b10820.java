// 2021-01-24 Yoo Jaein
// [BOJ] 10820 문자열 분석
// String

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		while((input = br.readLine()) != null) { // EOF 처리하기
			int lower = 0;
			int upper = 0;
			int num = 0;
			int blank = 0;
			
			for(int i=0; i<input.length(); i++) {
				if(Character.isLowerCase(input.charAt(i))) lower++;
				else if(Character.isUpperCase(input.charAt(i))) upper++;
				else if(Character.isDigit(input.charAt(i))) num++;
				else blank++;
			}
			System.out.println(lower+" "+upper+" "+num+" "+blank);
		}
		
		
		br.close();
		return;
	}
}