// 2020-10-30 Yoo Jaein
// [BOJ] 2941 크로아티아 알파벳
// String

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// dz= 을 먼저 변환해야 한다.
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i=0; i<croatia.length; i++) {
			str = str.replaceAll(croatia[i], "*");
		}
		
		int answer = str.length();
		System.out.println(answer);
		
		br.close();
		return;
	}
}