// 2020-09-05 Yoo Jaein
// [BOJ] 2902 KMP는 왜 KMP일까?
// String

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String answer = "";
		
		for(int i=0; i<s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i)))
				answer += s.charAt(i);
		}
		
		System.out.println(answer);		
		br.close();
    	return;
    }
}
