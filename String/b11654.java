// 2021-01-21 Yoo Jaein
// [BOJ] 11654 아스키 코드
// String

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = st.nextToken().codePointAt(0);
		
		System.out.println(n);
		
		br.close();
		return;
	}
}