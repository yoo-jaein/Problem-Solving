// 2020-09-05 Yoo Jaein
// [BOJ] 10798 세로읽기
// String

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = new String[5];
		
		for(int i=0; i<5; i++) {
			st[i] = br.readLine();
		}
		
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				if(st[j].length()>i)
					System.out.print(st[j].charAt(i));
			}
		}
		br.close();
    	return;
    }
}
