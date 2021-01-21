// 2021-01-21 Yoo Jaein
// [BOJ] 2908 상수
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		int ra = Integer.parseInt(new StringBuilder(a).reverse().toString());
		int rb = Integer.parseInt(new StringBuilder(b).reverse().toString());
		
		if(ra > rb) {
			System.out.println(ra);
		} else {
			System.out.println(rb);
		}
		
		br.close();
		return;
	}
}