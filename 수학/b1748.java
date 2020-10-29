// 2020-10-29 Yoo Jaein
// [BOJ] 1748 수 이어 쓰기 1
// 수학

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(1<=i && i<=9) cnt++;
			else if(10<=i && i<=99) cnt+=2;
			else if(100<=i && i<=999) cnt+=3;
			else if(1000<=i && i<=9999) cnt+=4;
			else if(10000<=i && i<=99999) cnt+=5;
			else if(100000<=i && i<=999999) cnt+=6;
			else if(1000000<=i && i<=9999999) cnt+=7;
			else if(10000000<=i && i<=99999999) cnt+=8;
			else cnt+=9;
		}
		System.out.println(cnt);
		
		br.close();
		return;
	}
}