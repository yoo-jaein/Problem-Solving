// 2020-09-14 Yoo Jaein
// [PRG] 17680 캐시
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cacheSize = 0;
		String[] cities = {"Jeju", "pop", "Jeju", "pop", "Jeju", "pop", "Jeju","Jeju"};
		HashMap<String, Integer> map = new HashMap<>();
		
		int time = 0;
		
		for(int i=0; i<cities.length; i++) {
			// 1. cache hit (+1)
			if(map.containsKey(cities[i].toLowerCase())) {
				map.put(cities[i].toLowerCase(), time);
				time++;
				//System.out.println(map.toString()+" "+time);
				continue;
			}
			
			// 2. cache miss (+5)
			// 2-1. queue.size()<cacheSize
			if(map.size()<cacheSize) {
				map.put(cities[i].toLowerCase(), time);
				time+=5;
				//System.out.println(map.toString()+" "+time);
				continue;
			}
			
			// 2-2. queue.size()==cacheSize
			// 가장 예전에 사용된 데이터를 삭제하고, 그 자리에 캐시를 넣는다.
			int min = 999999;
			String minKey = "";
			for(String key : map.keySet()) {
				if(min>map.get(key)) {
					min = map.get(key);
					minKey = key; 
				}
			}
			map.remove(minKey);
			map.put(cities[i].toLowerCase(), time);
			time+=5;
			//System.out.println(map.toString()+" "+time);
		}
		
		if(cacheSize==0) time = cities.length*5;
		System.out.println(time);
		
		br.close();
    	return;
    }
}
