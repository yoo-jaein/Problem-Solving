// 2020-09-05 Yoo Jaein
// [BOJ] 2914 저작권
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int l = Integer.parseInt(s[1]);
		
		int max = a*l;
		int answer = 0;
		for(int i=max; i>=0; i--) {
			if(Math.ceil((float)i/a)==l)
				continue;
			else {
				answer = i+1;
				break;
			}
		}
		System.out.println(answer);
		br.close();
    	return;
    }
}
