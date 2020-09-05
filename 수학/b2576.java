// 2020-09-05 Yoo Jaein
// [BOJ] 2576 홀수
// 수학

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = 101;
		int sum = 0;
		
		for(int i=0; i<7; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num%2!=0) { // 홀수
				sum += num;
				
				if(num<min)
					min = num;
			}	
		}
		if(sum==0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
		br.close();
    	return;
    }
}
