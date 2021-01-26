// 2021-01-25 Yoo Jaein
// [BOJ] 6996 애너그램
// String

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			int[] abc_a = new int[26];
			int[] abc_b = new int[26];
			
			
			for(int j=0; j<a.length(); j++) {
				abc_a[a.charAt(j)-'a']++;
			}
			
			for(int j=0; j<b.length(); j++) {
				abc_b[b.charAt(j)-'a']++;
			}
			
			System.out.print(a + " & " + b + " are ");
			
			for(int j=0; j<26; j++) {
				if(abc_a[j] != abc_b[j]) {
					// 애너그램이 아니다
					System.out.print("NOT ");
					break;
				}
			}
			System.out.println("anagrams.");
		}
		
		br.close();
		return;
	}
}