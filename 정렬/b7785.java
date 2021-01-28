// 2020-10-29 Yoo Jaein
// [BOJ] 7785 회사에 있는 사람
// Data Structure: HashMap

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			map.put(s[0], map.getOrDefault(s[0], 0)+1);
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(String name : map.keySet()) {
			if(map.get(name)%2!=0)
				list.add(name);
		}
		
		// 사전 순의 역순으로 출력
		Collections.sort(list, Comparator.reverseOrder());
		for(String name : list) {
			System.out.println(name);
		}
		
		br.close();
		return;
	}
}