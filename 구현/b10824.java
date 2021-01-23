// 2021-01-24 Yoo Jaein
// [BOJ] 10824 네 수
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// A와 B를 붙인 수
		long ab = Long.parseLong(st.nextToken() + st.nextToken()); 

		// C와 D를 붙인 수
		long cd = Long.parseLong(st.nextToken() + st.nextToken());

		// 두 수의 합
		System.out.println(ab + cd);
		
		br.close();
		return;
	}
}