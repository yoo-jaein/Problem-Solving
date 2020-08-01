// 2020-08-01 Yoo Jaein
// [BOJ] 2839 설탕 배달
// 구현

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int cnt = 9999;
		int a = 0, b = 0;
		
		for(int i=0; i<=N/3; i++) {
			for(int j=0; j<=N/5; j++) {
				if((3*i)+(5*j)==N && (i+j)<cnt) {
					cnt = i+j;
					a = i;
					b = j;
				}
			}
		}
				
		if((3*a)+(5*b)==N)
			System.out.println(cnt);
		else
			System.out.println(-1);
		
    	return;
    }
}
