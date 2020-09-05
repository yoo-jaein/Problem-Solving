// 2020-09-05 Yoo Jaein
// [BOJ] 10808 알파벳 개수
// String

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			map.put(s.charAt(i)-'a', map.getOrDefault(s.charAt(i)-'a', 0)+1);
		}
		
		for(int i=0; i<26; i++) {
			if(map.containsKey(i))
				System.out.print(map.get(i)+" ");
			else
				System.out.print(0+" ");
		}
		
		br.close();
    	return;
    }
}
