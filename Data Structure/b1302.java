// 2020-10-29 Yoo Jaein
// [BOJ] 1302 베스트셀러
// Data Structure: HashMap

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int max = 0;
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			map.put(s, map.getOrDefault(s, 0)+1);
			
			if(max<map.get(s)) 
				max = map.get(s);
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(String name : map.keySet()) {
			if(map.get(name)==max) {
				list.add(name);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(0));
		
		br.close();
		return;
	}
}