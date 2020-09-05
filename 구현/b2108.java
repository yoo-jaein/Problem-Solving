// 2020-09-05 Yoo Jaein
// [BOJ] 2108 통계학
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		// 산술평균
		System.out.println(Math.round((float)sum/n));
		
		// 중앙값
		Arrays.sort(arr);
		System.out.println(arr[n/2]);
		
		// 빈도 구하기 (arr[i], 빈도)
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 1)+1);
		}
		
		// 최빈값 구하기
		int max = 0;
		for(Integer value : map.values()) {
			if(max<value)
				max = value;
		}
		
		// 최빈값을 갖는 숫자를 list에 추가하기
		ArrayList<Integer> list = new ArrayList<>();
		for(Integer key : map.keySet()) {
			if(map.get(key)==max)
				list.add(key);
		}
		
		Collections.sort(list);
		if(list.size()>1)
			System.out.println(list.get(1));
		else
			System.out.println(list.get(0));
		
		// 범위 (최대값-최소값)
		System.out.println(arr[arr.length-1]-arr[0]);
		
    	return;
    }
}
