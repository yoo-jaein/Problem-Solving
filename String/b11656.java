// 2021-01-28 Yoo Jaein
// [BOJ] 11656 접미사 배열
// String

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<s.length(); i++) {
			list.add(s.substring(i));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		br.close();
		return;
	}
}