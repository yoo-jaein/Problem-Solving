// 2020-09-24 Yoo Jaein
// [BOJ] 9996 한국이 그리울 땐 서버에 접속하지
// String

import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		String pattern = br.readLine();
		
		// *을 기준으로 패턴을 분리한다.
		// head와 tail을 입력값을 비교한다.
		int pos = pattern.indexOf('*');
		String head = pattern.substring(0, pos);
		String tail = pattern.substring(pos+1, pattern.length());
		
		for(int i=0; i<n; i++)
			arr[i] = br.readLine();
		
		for(int i=0; i<n; i++) {
			boolean check = true;
			
			if(arr[i].length()<head.length()+tail.length())
				check = false;
			
			// * 앞 체크
			for(int j=0; j<head.length() && check; j++) {
				if(head.charAt(j)!=arr[i].charAt(j))
					check = false;
			}
			
			// * 뒤 체크
			for(int j=0; j<tail.length() && check; j++) {
				if(tail.charAt(j)!=arr[i].charAt(arr[i].length()-tail.length()+j))
					check = false;
			}
			
			if(check) System.out.println("DA");
			else System.out.println("NE");
		}
		
		br.close();
    	return;
    }
}
