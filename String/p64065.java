// 2020-08-10 Yoo Jaein
// [PRG] 64065 튜플
// 2019 카카오 개발자 겨울 인턴십

import java.io.*;
import java.util.*;

public class Main {
	
	public static int[] parsing(String s) {
		ArrayList<Integer> tmp = new ArrayList<>();
		String str = s.substring(1,s.length()-1); // 양 끝의 { } 제거
		
		String[] arr = str.split("}");
		
		// 길이 짧은 순서로 정렬
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		};
		
		Arrays.sort(arr,comp);

		int N = arr.length; // 튜플 원소의 개수
		for(int i=0; i<N; i++) {
			
			String str2 = arr[i];
			StringTokenizer st = new StringTokenizer(str2, "{,}");
			
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				
				if(tmp.contains(num))
					continue;
				else {
					tmp.add(num);
					break;
				}
			}
		}
		
		int[] answer = new int[tmp.size()];
		for(int i=0; i<answer.length; i++)
			answer[i] = tmp.get(i);
		
		return answer;
	
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	String s = br.readLine();
    	int[] answer = parsing(s);
    	
		for(int i=0; i<answer.length; i++)
			System.out.print(answer[i]+" ");
    	
    	return;
    }
}
