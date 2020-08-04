// 2020-08-05 Yoo Jaein
// [BOJ] 1764 듣보잡
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	int answer = 0;
    	
    	String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
    	
		Map<String, Integer> map = new TreeMap<>();
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 1);
		}
		
		Map<String, Integer> map2 = new TreeMap<>();
		for(int i=0; i<M; i++) {
			String str = br.readLine();	
			
			if(map.containsKey(str)) {
				map2.put(str, 1);
				answer++;
			}
		}
		
		System.out.println(answer);
		
		Set<String> ks = map2.keySet();
		for(String str : ks) {
			System.out.println(str);
		}
		
    	return;
    }
}
