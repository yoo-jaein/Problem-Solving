// 2020-09-05 Yoo Jaein
// [BOJ] 9324 진짜 메시지
// String

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String s = br.readLine();
			HashMap<Character, Integer> map = new HashMap<>();
			
			boolean flag = true;
			for(int j=0; j<s.length(); j++) {
				map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
				
				if(map.get(s.charAt(j))==3) {
					if(j<s.length()-1) {
						if(s.charAt(j+1)==s.charAt(j)) {
							map.remove(s.charAt(j));
							j++;
							continue;
						}
						else {
							flag = false;
							break;
						}
					}
					else {
						flag = false;
						break;
					}
				}
				
			}
			System.out.println(flag?"OK":"FAKE");
			
		}
		
		br.close();
    	return;
    }
}
